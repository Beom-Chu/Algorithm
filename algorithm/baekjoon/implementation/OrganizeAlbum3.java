package algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OrganizeAlbum3 {

    public static Album root = new Album("album", null);
    public static Album current;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[][] commands = new String[N][2];
        for (int i = 0; i < N; i++) {
            commands[i] = reader.readLine().split(" ");
        }

        current = root;

        for (String[] command : commands) {

            if (Objects.equals(command[0], "mkalb")) {
                current.mkAlb(command[1]);
            } else if (Objects.equals(command[0], "rmalb")) {
                current.rmAlb(command[1]);
            } else if (Objects.equals(command[0], "insert")) {
                current.insert(command[1]);
            } else if (Objects.equals(command[0], "delete")) {
                current.delete(command[1]);
            } else if (Objects.equals(command[0], "ca")) {
                ca(command[1]);
            }
        }
    }

    public static class Album {
        String name;
        Album parent;
        SortedMap<String, Album> subAlbums = new TreeMap<>();
        TreeSet<String> photos = new TreeSet<>();

        public Album(String name, Album parent) {
            this.name = name;
            this.parent = parent;
        }

        void mkAlb(String name) {
            if (this.subAlbums.containsKey(name)) {
                System.out.println("duplicated album name");
            } else {
                Album newAlbum = new Album(name, this);
                this.subAlbums.put(name, newAlbum);
            }
        }

        void rmAlb(String command) {
            Count count = new Count();
            if (!this.subAlbums.isEmpty()) {

                if (Objects.equals(command, "-1")) {
                    count.addCount(removeAlbCnt(this.subAlbums.get(this.subAlbums.firstKey())));
                    this.subAlbums.remove(this.subAlbums.firstKey());

                } else if (Objects.equals(command, "1")) {
                    count.addCount(removeAlbCnt(this.subAlbums.get(this.subAlbums.lastKey())));
                    this.subAlbums.remove(this.subAlbums.lastKey());

                } else if (Objects.equals(command, "0")) {
                    for(Map.Entry<String, Album> e : this.subAlbums.entrySet()) {
                        count.addCount(removeAlbCnt(this.subAlbums.get(e.getKey())));
                    }
                    this.subAlbums.clear();

                } else {
                    if (this.subAlbums.containsKey(command)) {
                        count.addCount(removeAlbCnt(this.subAlbums.get(command)));
                        this.subAlbums.remove(command);
                    }
                }
            }
            System.out.println(count.albumCount + " " + count.photoCount);
        }

        Count removeAlbCnt(Album removeAlbum) {
            Count count = new Count();
            count.albumCount++;
            count.photoCount += removeAlbum.photos.size();
            for(Map.Entry<String, Album> e : removeAlbum.subAlbums.entrySet()) {
                count.addCount(removeAlbCnt(removeAlbum.subAlbums.get(e.getKey())));
            }
            return count;
        }

        void insert(String name) {
            if (this.photos.contains(name)) {
                System.out.println("duplicated photo name");
            } else {
                this.photos.add(name);
            }
        }

        void delete(String command) {
            int deletePhotoCnt = 0;

            if (!this.photos.isEmpty()) {

                if (Objects.equals(command, "-1")) {
                    this.photos.pollFirst();
                    deletePhotoCnt++;

                } else if (Objects.equals(command, "1")) {
                    this.photos.pollLast();
                    deletePhotoCnt++;

                } else if (Objects.equals(command, "0")) {
                    deletePhotoCnt += this.photos.size();
                    this.photos.clear();

                } else {
                    if (this.photos.contains(command)) {
                        this.photos.remove(command);
                        deletePhotoCnt++;
                    }
                }
            }
            System.out.println(deletePhotoCnt);
        }
    }

    public static class Count {
        int albumCount;
        int photoCount;

        public Count() {
            this.albumCount = 0;
            this.photoCount = 0;
        }

        public void addCount(Count addCount) {
            this.albumCount += addCount.albumCount;
            this.photoCount += addCount.photoCount;
        }
    }

    static public void ca(String command) {
        if (Objects.equals(command, "/")) {
            current = root;
        } else if (Objects.equals(command, "..")) {
            if (current.parent != null) {
                current = current.parent;
            }
        } else {
            if(current.subAlbums.containsKey(command)) {
                current = current.subAlbums.get(command);
            }
        }
        System.out.println(current.name);
    }
}
