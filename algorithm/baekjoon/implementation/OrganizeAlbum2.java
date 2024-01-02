package algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class OrganizeAlbum2 {

    public static int rmAlbumCnt, deletePhotoCnt;
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
        List<Album> subAlbums = new ArrayList<>();
        List<String> photos = new ArrayList<>();

        public Album(String name, Album parent) {
            this.name = name;
            this.parent = parent;
        }

        void mkAlb(String name) {
            if (getSubAlbum(this.subAlbums, name).isPresent()) {
                System.out.println("duplicated album name");
            } else {
                Album newAlbum = new Album(name, this);
                this.subAlbums.add(newAlbum);
            }
        }

        void rmAlb(String command) {
            rmAlbumCnt = 0;
            deletePhotoCnt = 0;

            if (!this.subAlbums.isEmpty()) {
                if (Objects.equals(command, "-1")) {
                    this.subAlbums.sort(Comparator.comparing(o -> o.name));
                    checkRemoveCnt(this.subAlbums.get(0));
                    this.subAlbums.remove(0);
                } else if (Objects.equals(command, "1")) {
                    this.subAlbums.sort(Comparator.comparing(o -> o.name));
                    checkRemoveCnt(this.subAlbums.get(this.subAlbums.size() - 1));
                    this.subAlbums.remove(this.subAlbums.size() - 1);
                } else if (Objects.equals(command, "0")) {
                    for (Album rmAlbum : this.subAlbums) {
                        checkRemoveCnt(rmAlbum);
                    }
                    this.subAlbums.clear();
                } else {
                    Optional<Album> optionalAlbum = getSubAlbum(this.subAlbums, command);
                    if (optionalAlbum.isPresent()) {
                        Album rmAlbum = optionalAlbum.get();
                        checkRemoveCnt(rmAlbum);
                        this.subAlbums.remove(rmAlbum);
                    }
                }
            }
            System.out.println(rmAlbumCnt + " " + deletePhotoCnt);
        }

        void insert(String name) {
            if (this.photos.contains(name)) {
                System.out.println("duplicated photo name");
            } else {
                this.photos.add(name);
            }
        }

        void delete(String command) {
            deletePhotoCnt = 0;
            if (!this.photos.isEmpty()) {
                if (Objects.equals(command, "-1")) {
                    this.photos.sort(Comparator.naturalOrder());
                    this.photos.remove(0);
                    deletePhotoCnt++;
                } else if (Objects.equals(command, "1")) {
                    this.photos.sort(Comparator.naturalOrder());
                    this.photos.remove(this.photos.size() - 1);
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

    static public Optional<Album> getSubAlbum(List<Album> subAlbums, String name) {
        return subAlbums.stream()
                .filter(o -> o.name.equals(name))
                .findAny();
    }

    static public void checkRemoveCnt(Album rmAlbum) {
        rmAlbumCnt++;
        deletePhotoCnt += rmAlbum.photos.size();
        for (Album album : rmAlbum.subAlbums) {
            checkRemoveCnt(album);
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
            getSubAlbum(current.subAlbums, command).ifPresent(album -> current = album);
        }
        System.out.println(current.name);
    }
}
