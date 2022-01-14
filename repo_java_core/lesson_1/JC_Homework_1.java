/**
 * Java Core. Homework for Lesson 1
 *
 * @author Marina Dumcheva
 * @version 13.12.2021
 */

import java.util.Scanner;

class JC_Homework_1 {
    public static void main(String[] args) {

        // Creating teams
        Team team1 = new Team("Spartak", 4);
        team1.playerArr[0] = new Player("Sergey", 2000, 200, 80);
        team1.playerArr[1] = new Player("Sofia", 1000, 100, 100);
        team1.playerArr[2] = new Player("Sem", 1500, 150, 115);
        team1.playerArr[3] = new Player("Stepan", 3000, 300, 130);

        Team team2 = new Team("Dinamo", 4);
        team2.playerArr[0] = new Player("Danil", 2100, 200, 80);
        team2.playerArr[1] = new Player("David", 2100, 100, 80);
        team2.playerArr[2] = new Player("Dariya", 2100, 200, 80);
        team2.playerArr[3] = new Player("Diana", 2100, 150, 80);

        // Printing the information about the teams
        System.out.println("Teams participate in the competition:");
        System.out.println();
        team1.infoTeam();
        System.out.println();
        team2.infoTeam();

        // Creating a course
        Course course = new Course(2000, 100, 80);

        // Passing the distance
        course.doCourse(team1);
        course.doCourse(team2);

        // Printing the results
        System.out.println();
        System.out.println();
        System.out.println("Reults:");
        System.out.println();
        team1.infoDoDistance();
        System.out.println();
        team2.infoDoDistance();
    }

}
class Team {
    protected String nameTeam;
    protected Player[] playerArr;

    Team (String nameTeam, int lengthTeam) {
        this.nameTeam = nameTeam;
        this.playerArr = new Player[lengthTeam];
    }

    void infoTeam() {
        System.out.print("Team " + nameTeam + " - ");
        for (int i = 0; i < playerArr.length; i++) {
            System.out.print(playerArr[i] + ", ");
        }
    }

    void infoDoDistance() {
        System.out.println("Team " + nameTeam + ": ");
        for (int i = 0; i < playerArr.length; i++) {
            System.out.println(playerArr[i] + " - " + this.playerArr[i].passingDistance);
        }
    }

    String getNameTeam() {
    return nameTeam;
    }

    void setName(String nameTeam) {
        this.nameTeam = nameTeam;
    }
}

class Player {
    private String name;
    private int maxRun;
    private int maxSwim;
    private int maxJump;
    boolean passingDistance;

    Player (String name, int maxRun, int maxSwim, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getMaxRun() {
        return maxRun;
    }

    void setMaxRun(int maxRun) {
    if (maxRun >= 0) {
        this.maxRun = maxRun;
        }
    }

    int getMaxSwim() {
        return maxSwim;
    }

    void setMaxSwim(int maxSwim) {
        if (maxSwim >= 0) {
        this.maxSwim = maxSwim;
        }
    }

    int getMaxJump() {
        return maxSwim;
    }

    void setMaxJump(int maxJump) {
        if (maxJump >= 0 && maxJump <= 150) {
        this.maxJump = maxJump;
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}

class Course {
    int distanceRun;
    int distanceSwim;
    int heightCrossbar;

    Course (int distanceRun, int distanceSwim, int heightCrossbar) {
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
        this.heightCrossbar = heightCrossbar;
    }

    void doCourse(Team team) {
        for (int i = 0; i < team.playerArr.length; i++) {
        if (this.distanceRun <= team.playerArr[i].getMaxRun() && this.distanceSwim <= team.playerArr[i].getMaxSwim() && this.heightCrossbar <= team.playerArr[i].getMaxJump()) {
            team.playerArr[i].passingDistance = true;
            }
        }
    }
}