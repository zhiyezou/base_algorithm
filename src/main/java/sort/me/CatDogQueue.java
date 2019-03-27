package sort.me;


import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
    private Queue<PetEnterQueue> cat = null;
    private Queue<PetEnterQueue> dog = null;
    private long count = 0;

    public class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static void main(String[] args) {

    }

    public class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getEnterPetType() {
            return this.pet.getType();
        }
    }

    public CatDogQueue() {
        this.cat = new LinkedList<>();
        this.dog = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType() == "dog") {
            dog.add(new PetEnterQueue(pet, count++));
        } else if (pet.getType() == "cat") {
            cat.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!this.dog.isEmpty() && !this.cat.isEmpty()) {
            if (this.dog.peek().getCount() < this.cat.peek().getCount()) {
                return cat.poll().getPet();
            } else {
                return dog.poll().getPet();
            }

        } else if (!this.dog.isEmpty()) {
            return this.dog.poll().getPet();
        } else if (!this.cat.isEmpty()) {
            return this.cat.poll().getPet();
        } else {
            throw new RuntimeException("queue is empty");
        }
    }
}
