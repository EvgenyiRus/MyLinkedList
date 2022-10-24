package com.example.one;

import lombok.NoArgsConstructor;

import java.util.logging.Logger;

@NoArgsConstructor
public class Service {

    static Logger logger = Logger.getLogger(Service.class.getName());

    public static void execute() {
        MyLinkedListImpl<Integer> myLinkedList = new MyLinkedListImpl();
        myLinkedList = myLinkedList.add(2, myLinkedList);
        myLinkedList = myLinkedList.add(3, myLinkedList);
        myLinkedList = myLinkedList.add(1, myLinkedList);
        myLinkedList = myLinkedList.add(3, myLinkedList);
        myLinkedList = myLinkedList.add(5, myLinkedList);
        myLinkedList = myLinkedList.add(6, myLinkedList);
        myLinkedList = myLinkedList.add(2, myLinkedList);
        logger.info(String.format("new linkedList after adding : {%s}", myLinkedList));

        myLinkedList.set(2, new Node<>(22), myLinkedList);
        logger.info(String.format("set new value 22 for index = 2 : {%s}", myLinkedList));

        myLinkedList.quickSort(myLinkedList, 0, myLinkedList.size-1);
        logger.info(String.format("linkedList after sorting : {%s}", myLinkedList));

        myLinkedList = myLinkedList.removeByValue(3, myLinkedList);
        logger.info(String.format("new linkedList after removing value=3: {%s}", myLinkedList));

        myLinkedList = myLinkedList.removeByValue(2, myLinkedList);
        logger.info(String.format("new linkedList after removing value=2 : {%s}", myLinkedList));

        myLinkedList = myLinkedList.removeByValue(2, myLinkedList);
        logger.info(String.format("new linkedList after removing value=2 : {%s}", myLinkedList));

        myLinkedList = myLinkedList.removeByValue(12, myLinkedList);
        logger.info(String.format("new linkedList after removing value=12 : {%s}", myLinkedList));

        Node<Integer> node = myLinkedList.get(0, myLinkedList);
        logger.info(String.format("get value for index = 0 : {%s}", node));

        node = myLinkedList.get(2, myLinkedList);
        logger.info(String.format("get value for index = 2 : {%s}", node));
    }
}
