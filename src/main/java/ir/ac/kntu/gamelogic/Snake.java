package ir.ac.kntu.gamelogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Snake {
    private int length;

    private int numberOfNormalSnake=1;

    private int numberOfWildSnake=1;

    private int numberOfKindSnake=1;

    private ArrayList<Integer> locationOfNormalSnake=new ArrayList<>();

    private ArrayList<Integer> locationOfKindSnake=new ArrayList<>();

    private ArrayList<Integer> locationOfWildSnake=new ArrayList<>();

    private ArrayList<HashMap<Integer,Integer>> headsLocation=new ArrayList<>();

    private ArrayList<HashMap<Integer,Integer>> tailLocation=new ArrayList<>();

    private ArrayList<HashMap<Integer,Integer>> wildHeadsLocation=new ArrayList<>();

    private ArrayList<HashMap<Integer,Integer>> wildTailLocation=new ArrayList<>();

    public Snake(int length){
        this.length=length;
        setSnakes();
    }

    private void setNumberOfNormalSnake(){
        numberOfNormalSnake+=length/2;
    }

    private void setNumberOfWildSnake(){
        numberOfWildSnake+=length/3;
    }

    private void setNumberOfKindSnake(){
        numberOfKindSnake+=length/3;
    }


    public ArrayList<Integer> getLocationOfNormalSnake() {
        return locationOfNormalSnake;
    }

    public ArrayList<Integer> getLocationOfKindSnake() {
        return locationOfKindSnake;
    }

    public ArrayList<Integer> getLocationOfWildSnake() {
        return locationOfWildSnake;
    }

    private void setLocationOfNormalSnake(){
        Random random=new Random();
        while (true) {
            int headX = random.nextInt(length);
            int headY = random.nextInt(1, length);
            HashMap<Integer, Integer> head = new HashMap<>();
            head.put(headX, headY);
            if (!headsLocation.contains(head)&&!tailLocation.contains(head)&&!wildHeadsLocation.contains(head)&&!wildTailLocation.contains(head)) {
                int tailX = random.nextInt(length);
                int tailY = random.nextInt(headY);
                HashMap<Integer, Integer> tail = new HashMap<>();
                tail.put(tailX, tailY);
                if (!headsLocation.contains(tail)&&!wildHeadsLocation.contains(tail)) {
                    headsLocation.add(head);
                    tailLocation.add(tail);
                    locationOfNormalSnake.add(headX);
                    locationOfNormalSnake.add(headY);
                    locationOfNormalSnake.add(tailX);
                    locationOfNormalSnake.add(tailY);
                    break;
                }
            }
        }
    }

    private void setLocationOfWildSnake(){
        Random random=new Random();
        while (true) {
            int headX = random.nextInt(length);
            int headY = random.nextInt((1), length);
            HashMap<Integer, Integer> head = new HashMap<>();
            head.put(headX, headY);
            if (!headsLocation.contains(head)&&!tailLocation.contains(head)&&!wildHeadsLocation.contains(head)&&!wildTailLocation.contains(head)) {
                int tailX = random.nextInt(length);
                int tailY = random.nextInt(headY);
                HashMap<Integer, Integer> tail = new HashMap<>();
                tail.put(tailX, tailY);
                if (!headsLocation.contains(tail)&&!wildHeadsLocation.contains(tail)) {
                    wildHeadsLocation.add(head);
                    wildTailLocation.add(tail);
                    locationOfWildSnake.add(headX);
                    locationOfWildSnake.add(headY);
                    locationOfWildSnake.add(tailX);
                    locationOfWildSnake.add(tailY);
                    break;
                }
            }
        }
    }

    private void setLocationOfKindSnake(){
        Random random=new Random();
        while (true) {
            int headX = random.nextInt(length);
            int headY = random.nextInt(length-1);
            HashMap<Integer, Integer> head = new HashMap<>();
            head.put(headX, headY);
            if (!headsLocation.contains(head)&&!tailLocation.contains(head)&&!wildHeadsLocation.contains(head)&&!wildTailLocation.contains(head)) {
                int tailX = random.nextInt(length);
                int tailY = random.nextInt(headY+1,length);
                HashMap<Integer, Integer> tail = new HashMap<>();
                tail.put(tailX, tailY);
                if (!headsLocation.contains(tail)&&!wildHeadsLocation.contains(tail)) {
                    headsLocation.add(head);
                    tailLocation.add(tail);
                    locationOfKindSnake.add(headX);
                    locationOfKindSnake.add(headY);
                    locationOfKindSnake.add(tailX);
                    locationOfKindSnake.add(tailY);
                    break;
                }
            }
        }
    }

    private void setSnakes(){
        if (length>0) {
            setNumberOfNormalSnake();
            for (int i = 0; i < numberOfNormalSnake; i++) {
                setLocationOfNormalSnake();
            }
            setNumberOfKindSnake();
            for (int i = 0; i < numberOfKindSnake; i++) {
                setLocationOfKindSnake();
            }
            setNumberOfWildSnake();
            for (int i = 0; i < numberOfWildSnake; i++) {
                setLocationOfWildSnake();
            }
        }
    }

    public void setWildSnake(){
        locationOfWildSnake.clear();
        wildHeadsLocation.clear();
        wildTailLocation.clear();
        numberOfWildSnake=1;
        setNumberOfWildSnake();
        for (int i = 0; i < numberOfWildSnake; i++) {
            setLocationOfWildSnake();
        }
    }
}
