package ru.sber.collection2;

import ru.sber.collection1.Collection;
import ru.sber.collection1.ArrayList;

import java.util.Objects;

public class TreeMap implements Map {

    private enum Color {
        RED,
        BLACK
    }

    private static class Node {

        Object key;

        Object value;

        Node left = null;

        Node right = null;

        Node parent = null;

        Color color = Color.RED;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

    }

    private static class NullNode extends Node {

        private NullNode() {
            super(0, 0);
            this.color = Color.BLACK;
        }
        
    }

    private Node rootNode;

    private int size = 0;

    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
            this.rootNode = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            throw new IllegalStateException("Узел не является ребенком этих родителей");
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }

    private void rotateRight(Node currentNode) {
        Node parent = currentNode.parent;
        Node leftChild = currentNode.left;

        currentNode.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = currentNode;
        }

        leftChild.right = currentNode;
        currentNode.parent = leftChild;

        replaceParentsChild(parent, currentNode, leftChild);
    }

    private void rotateLeft(Node currentNode) {
        Node parent = currentNode.parent;
        Node rightChild = currentNode.right;

        currentNode.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = currentNode;
        }

        rightChild.left = currentNode;
        currentNode.parent = rightChild;

        replaceParentsChild(parent, currentNode, rightChild);
    }

    private Node findByKey(Object key) {
        Node node = this.rootNode;
        int keyHashCode = Objects.hashCode(key);

        while (node != null) {
            int nodeHashCode = Objects.hashCode(node.key);

            if (keyHashCode == nodeHashCode) {
                return node;
            } else if (keyHashCode < nodeHashCode) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return null;
    }

    private Node findByValue(Node currentNode, Object value) {
        if (currentNode == null) {
            return null;
        }

        if (Objects.equals(currentNode.value, value)) {
            return currentNode;
        }

        Node foundNode = findByValue(currentNode.left, value);
        if (foundNode == null) {
            foundNode = findByValue(currentNode.right, value);
        }

        return foundNode;
    }

    private static Node getUncle(Node parent) {
        Node grandparent = parent.parent;

        if (grandparent.left == parent) {
            return grandparent.right;
        } else if (grandparent.right == parent) {
            return grandparent.left;
        }

        throw new IllegalStateException("Узел не является ребенком этого прародителя");
    }

    // Это веселая функция...
    // В основном потому что нужно подчиняться нескольким правилами красно-черного дерева.
    // Они следующие:
    // 1. Каждый узел является либо красным, либо черным (отсюда и название).
    // 2. Корень ВСЕГДА должен быть черным.
    // 3. Все null листья должны быть черными.
    // 4. Красный узел НЕ ДОЛЖЕН иметь красных детей.
    // 5. Все пути от узла к листьям должны содержать под собой одинаковое количество черных узлов.
    //
    // Следовательно, можно разбить данную функцию на 5 частей:
    // 1. Новый узел является корнем (правило 2) -> Просто перекрасим его в черный (все узлы по умолчанию красные).
    // 2. Родительский узел красный и является корнем -> Данный случай не возможен по причине того, что корень всегда является черным.
    // Поэтому это правило можно опустить (однако если бы корень мог быть красным, то его нужно было бы соблюдать).
    // 3. У нашего отца имеется дядя и его цвет сейчас красный -> У нас получается цепочка из красного отца и красного сына.
    // Это невозможно по правилу 4, однако если поменять цвет отца на черный, то может оказаться, что у него есть дядя, цвет которого все ещё красный.
    // Следовательно, нужно исправить и его цвет. ОДНАКО (как сложно все) тогда их отец и они сами будут черные, поэтому мы перекрашиваем их отца (наш дедушка) в черный.
    //
    // - Это будет сложно, но я попробую объяснить на пальцах.
    // 4. Наш отец является красным, дядя черным (в этом случае null по правилу 3), и мы являемся "внутренним" внуком.
    // Под внутренним имеется ввиду что мы пошли по левой ветке, когда наш папа и дедушка были на правой, и наоборот.
    // То есть нам нужно перейти на другую ветку (то есть правую), а затем сделать поворот вокруг дедушки в противоположную сторону (то есть влево).
    // И затем нужно перекрасить нового отца и старого дедушку, так как теперь отец является красным, как и мы (то есть он должен стать черным).
    // А дедушка является черным, то есть он должен стать красным, чтобы не нарушать правило 4.
    // 5. Наш отец является красным, дядя черным (в этом случае null по правилу 3), и мы являемся "внешним" внуком.
    // Все то же самое что и в случае 4, кроме первого действия (то есть мы выполняем все действия на той же ветке).
    private void fixRedBlackPropertiesAfterInsert(Node currentNode) {
        Node parent = currentNode.parent;

        // Случай 1: Новый узел является корнем
        if (parent == null) {
            currentNode.color = Color.BLACK;
            return;
        }

        if (parent.color == Color.BLACK) {
            return;
        }

        Node grandparent = parent.parent;
        // Здесь должен быть случай 2, но так как корень здесь черный, то можно опустить данный момент

        Node uncle = getUncle(parent);

        // Случай 3: У нашего отца имеется дядя и его цвет сейчас красный
        if (uncle != null && uncle.color == Color.RED) {
            // То есть наш отец и дядя должны стать черными (как же это звучит XD), чтобы не нарушать правило 4
            // А наш дедушка должен стать красным, чтобы сохранить последовательность

            parent.color = Color.BLACK;
            grandparent.color = Color.RED;
            uncle.color = Color.BLACK;

            // И теперь, когда наш дедушка стал красным, нам нужно починить все узлы выше
            // Так как возможен вариант когда прадедушка и дедушка будут оба красными (что нарушает правило 4)
            fixRedBlackPropertiesAfterInsert(grandparent);
        } else if (parent == grandparent.left) {
            // Наш папа является левым ребенком нашего дедушки

            // Проверяем, являемся ли мы "внутренним" ребенком (то есть правым у отца)
            if (currentNode == parent.right) {
                rotateLeft(parent);
                parent = currentNode;
            }

            // Переворачиваем ветку вокруг дедушки в противоположную сторону
            rotateRight(grandparent);

            // И перекрашиваем отца и дедушку дабы не нарушать правило 4
            parent.color = Color.BLACK;
            grandparent.color = Color.RED;
        } else {
            // Наш папа является правым ребенком нашего дедушки

            // Проверяем, являемся ли мы "внутренним" ребенком (то есть левым у отца)
            if (currentNode == parent.left) {
                rotateRight(parent);
                parent = currentNode;
            }

            // Переворачиваем ветку вокруг дедушки в противоположную сторону
            rotateLeft(grandparent);

            // И перекрашиваем отца и дедушку дабы не нарушать правило 4
            parent.color = Color.BLACK;
            grandparent.color = Color.RED;
        }
    }

    // Будет работать только если количество детей у узла меньше двух
    private Node deleteNode(Node nodeToDelete) {
        if (nodeToDelete.left != null) {
            replaceParentsChild(nodeToDelete.parent, nodeToDelete, nodeToDelete.left);
            return nodeToDelete.left;
        } else if (nodeToDelete.right != null) {
            replaceParentsChild(nodeToDelete.parent, nodeToDelete, nodeToDelete.right);
            return nodeToDelete.right;
        } else {
            Node newChild = nodeToDelete.color == Color.BLACK ? new NullNode() : null;
            replaceParentsChild(nodeToDelete.parent, nodeToDelete, newChild);
            return newChild;
        }
    }

    private static Node findLast(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    private static Node getSibling(Node currentNode) {
        Node parent = currentNode.parent;

        if (currentNode == parent.left) {
            return parent.right;
        } else if (currentNode == parent.right) {
            return parent.left;
        }

        throw new IllegalStateException("Узел не является ребенком этого прародителя");
    }

    private void handleRedSibling(Node currentNode, Node sibling) {
        sibling.color = Color.BLACK;
        currentNode.parent.color = Color.RED;

        if (currentNode == currentNode.parent.left) {
            rotateLeft(currentNode.parent);
        } else {
            rotateRight(currentNode.parent);
        }
    }

    private static boolean isBlack(Node currentNode) {
        return currentNode == null || currentNode.color == Color.BLACK;
    }

    private void handleBlackSibling(Node currentNode, Node sibling) {
        boolean nodeIsLeftChild = currentNode == currentNode.parent.left;

        // Случай 5: Черный близнец с хотя бы одним красным ребенком
        // И внешний внук является черным
        if (nodeIsLeftChild && isBlack(sibling.right)) {
            sibling.left.color = Color.BLACK;
            sibling.color = Color.RED;
            rotateRight(sibling);
            sibling = currentNode.parent.right;
        } else if (!nodeIsLeftChild && isBlack(sibling.left)) {
            sibling.right.color = Color.BLACK;
            sibling.color = Color.RED;
            rotateLeft(sibling);
            sibling = currentNode.parent.left;
        }

        // Случай 5 является частным случаем случая 5, так что "проваливаемся" в решение случая 6
        // Собственно, случай 6: Черный близнец с хотя бы одним красным ребенком
        // И внешний внук является красным
        sibling.color = currentNode.parent.color;
        currentNode.parent.color = Color.BLACK;

        if (nodeIsLeftChild) {
            sibling.right.color = Color.BLACK;
            rotateLeft(currentNode.parent);
        } else {
            sibling.left.color = Color.BLACK;
            rotateRight(currentNode.parent);
        }
    }

    // Это тоже интересная функция, все правила здесь также работают, как и для вставки нового элемента (можно почитать выше).
    // Здесь есть на 1 случай больше.
    // 1. Удаляемый узел является корнем -> Все просто если нет детей - заменяем его на null.
    // В случае же, если у корневого узла есть один ребенок - просто сдвигаем его на место корня и меняем цвет нового корня (который является красным) на черный.
    // Почему так просто? Потому что если бы у ребенка был бы черный узел - то это нарушило бы 5 правило, а если бы красный - то 4 правило.
    // Следовательно, если у корня только один ребенок - то это единственный узел.
    //
    // Во всех остальных случаях мы должны проверить второго ребенка у узла, у которого удалили ребенка (близнец).
    // И условия достаточно сильно разняться, от простых одно-уровневых до сложных трех-уровневых.
    // Итак, продолжим.
    // 2. Близнец является красным.
    // В таком случае перекрашиваем отца в черный и нарушаем правило 5, не хорошо.
    // Для этого сделаем поворот в сторону удаленного элемента (удалили левый - и крутим налево).
    // Теперь у нас получилось, что старый отец имеет только 1 ребенка, когда все остальные имеют 2 (null тоже считается).
    // Для этого нужно просто поменять цвета у старого отца на красный и у старого близнеца на черный.
    // Тогда дерево будет иметь в себе на каждом конце 2 черных узла, что делает дерево снова правильным.
    // 3. Близнец черный и имеет двух черных детей, отец красный.
    // Это удаление сразу же нарушает правило 5, так как у нас на один узел меньше, чем у остальных.
    // Так как близнец черный, а отец красный, и все дети у близнеца черные, то можно без страха менять цвет отца на черный и близнеца на красный.
    // 4. Близнец черный и имеет двух черных детей, отец также черный.
    // Снова правило 5 - на пути удаленного узла у нас только один черный листочек вместо двух, как у всех.
    // Сперва перекрасим близнеца в красный, что означает, что длина листьев на этой ветке будет правильной, но не на противоположной.
    // Правило 5 все ещё нарушено. Для исправления этого можно воспользоваться рекурсией и вызвать метод восстановления на уровень выше.
    // В таком случае у нас получается, что близнец черный и имеет двух черных детей, а также красного отца, то есть мы снова в случае 3.
    // То есть нужно перекрасить отца на черный и близнеца на красный.
    // 5. Близнец черный и имеет КАК МИНИМУМ одного КРАСНОГО ребенка, а ребенок близнеца на противоположной стороне от удаленного узла является черным (внешний внук).
    // Так как родитель удаленного узла красный (по правилу 4 и 5), то меняем цвет близнеца на красный и цвет его ребенка на черный (чтобы оба стали черными)
    // Теперь мы нарушаем сразу 4 и 5 правило, но это нужно для того, чтобы выстроить линию из узлов.
    // Для этого прокручиваем узлы в центре близнеца в ПРОТИВОПОЛОЖНУЮ сторону от удаленного узла.
    // Дальше мы снова перекрашиваем узлы: отца и нового ребенка в черный, а близнеца, вокруг которого крутили, в красный
    // И прокручиваем снова во круг отца в сторону удаленного узла.
    // Теперь дерево снова стабилизировано.
    // 6. Близнец черный и имеет КАК МИНИМУМ одного КРАСНОГО ребенка, и ребенок близнеца на противоположной стороне от удаленного узла является красным (внешний внук).
    // Снова нарушение правила 5, но теперь, в отличие от случая 5, ребенок близнеца на противоположной стороне от удаленного узла красный.
    // Сперва перекрашиваем близнеца в цвет отца, а затем красим отца и "внешнего" внука в черный.
    // И теперь мы поворачиваем вокруг отца в сторону удаленного узла.
    // Дерево успешно восстановлено.
    private void fixRedBlackPropertiesAfterDelete(Node currentNode) {
        // Случай 1: Узел является корнем
        if (currentNode == this.rootNode) {
            currentNode.color = Color.BLACK;
            return;
        }

        Node sibling = getSibling(currentNode);

        // Случай 2: Красный близнец
        if (sibling.color == Color.RED) {
            handleRedSibling(currentNode, sibling);
            sibling = getSibling(currentNode);
        }

        // Случай 3 и 4: Черный близнец с двумя черными детьми (или null листьями)
        if (isBlack(sibling.left) && isBlack(sibling.right)) {
            sibling.color = Color.RED;

            // Случай 3: Черный близнец с двумя черными детьми (или null листьями) и красный родитель
            if (currentNode.parent.color == Color.RED) {
                currentNode.parent.color = Color.BLACK;
            } else {
                // Случай 4: Черный близнец с двумя черными детьми (или null листьями) и черный родитель
                fixRedBlackPropertiesAfterDelete(currentNode.parent);
            }
        } else {
            // Случай 5 и 6: Черный близнец с хотя бы одним красным ребенком
            handleBlackSibling(currentNode, sibling);
        }
    }

    private void traverseKeysInOrder(Node currentNode, ArrayList collection) {
        if (currentNode == null) {
            return;
        }

        traverseKeysInOrder(currentNode.left, collection);
        collection.add(currentNode.key);
        traverseKeysInOrder(currentNode.right, collection);
    }

    private void traverseValuesInOrder(Node currentNode, ArrayList collection) {
        if (currentNode == null) {
            return;
        }

        traverseValuesInOrder(currentNode.left, collection);
        collection.add(currentNode.value);
        traverseValuesInOrder(currentNode.right, collection);
    }

    private void traversePairsInOrder(Node currentNode, ArrayList collection) {
        if (currentNode == null) {
            return;
        }

        traversePairsInOrder(currentNode.left, collection);
        collection.add(new KeyValue(currentNode.key, currentNode.value));
        traversePairsInOrder(currentNode.right, collection);
    }

    public TreeMap() {
        this.rootNode = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return findByKey(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return findByValue(this.rootNode, value) != null;
    }

    @Override
    public Object get(Object key) {
        Node node = findByKey(key);

        if (node == null) {
            return null;
        }

        return node.value;
    }

    @Override
    public Object put(Object key, Object value) {
        Node node = this.rootNode;
        Node parent = null;
        Object objectToReturn;
        int keyHashCode = Objects.hashCode(key);

        while (node != null) {
            parent = node;
            int nodeHashCode = Objects.hashCode(node.key);

            if (keyHashCode < nodeHashCode) {
                node = node.left;
            } else if (keyHashCode > nodeHashCode) {
                node = node.right;
            } else {
                objectToReturn = node.value;
                node.value = value;
                return objectToReturn;
            }
        }

        Node newNode = new Node(key, value);
        newNode.color = Color.RED;

        if (parent == null) {
            this.rootNode = newNode;
        } else if (keyHashCode < Objects.hashCode(parent.key)) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        newNode.parent = parent;
        fixRedBlackPropertiesAfterInsert(newNode);

        this.size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        Node node = this.rootNode;
        int keyHashCode = Objects.hashCode(key);

        while (node != null && Objects.hashCode(node.key) != keyHashCode) {
            if (keyHashCode < Objects.hashCode(node.key)) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (node == null) {
            return null;
        }

        Object objectToReturn = node.value;
        Node movedUpNode;
        Color deletedNodeColor;

        if (node.left == null || node.right == null) {
            movedUpNode = deleteNode(node);
            deletedNodeColor = node.color;
        } else {
            Node inOrderSuccessor = findLast(node.right);

            node.key = inOrderSuccessor.key;

            movedUpNode = deleteNode(inOrderSuccessor);
            deletedNodeColor = inOrderSuccessor.color;
        }

        if (deletedNodeColor == Color.BLACK) {
            fixRedBlackPropertiesAfterDelete(movedUpNode);

            // Используем временную пустышку дабы восстановить дерево в правильном порядке
            if (movedUpNode.getClass() == NullNode.class) {
                replaceParentsChild(movedUpNode.parent, movedUpNode, null);
            }
        }

        this.size--;
        return objectToReturn;
    }

    @Override
    public void clear() {
        this.rootNode = null;
        this.size = 0;
    }

    @Override
    public Collection values() {
        ArrayList values = new ArrayList();
        traverseValuesInOrder(this.rootNode, values);
        return values;
    }

    @Override
    public Collection keySet() {
        ArrayList keys = new ArrayList();
        traverseKeysInOrder(this.rootNode, keys);
        return keys;
    }

    @Override
    public Collection entrySet() {
        ArrayList pairs = new ArrayList();
        traversePairsInOrder(this.rootNode, pairs);
        return pairs;
    }
}
