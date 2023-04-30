package classes;
import classes.Channels;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args){

        List<Channels> channelsList = new ArrayList<>();
        readChannels(channelsList);

        System.out.println("Welcome to the Channel Switcher");

        Scanner scanner = new Scanner(System.in);
        Integer option;
        Boolean correct;
        Boolean correct1;

        do {
            correct = true;
            try {
                System.out.println("Press 1 if you want to see the list of all currently available channels \n" + "Press 2 if you want to see the list of all currently available active channels \n" + "Press 3 if you want to see the list of all currently available inactive channels \n" + "Press 4 to change the channel status \n" + "Press 5 to end the program");
                option = scanner.nextInt();
                scanner.nextLine();

                if (option == 1) {
                    System.out.println(channelsList);

                    do {
                        correct1 = true;
                        try {
                            System.out.println("\nPress 1 to return to the selection");
                            option = scanner.nextInt();
                            scanner.nextLine();
                            if (option == 1) {
                                correct = false;
                            } else if (option <= 1 || option >= 1) {
                                System.out.println("Please enter number 1!");
                                correct1 = false;
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("You have not entered a number please enter a number!");
                            scanner.nextLine();
                            correct1 = false;
                        }
                    } while (!correct1);
                } else if (option == 2) {

                    System.out.println("These channels are active");
                    for (Channels channel : channelsList) {
                        if (channel.getStatus().equals("Active")) {
                            System.out.println(channel.getName());
                        }
                    }

                    do {
                        correct1 = true;
                        try {
                            System.out.println("\nPress 1 to return to the selection");
                            option = scanner.nextInt();
                            scanner.nextLine();
                            if (option == 1) {
                                correct = false;
                            } else if (option <= 1 || option >= 1) {
                                System.out.println("Please enter number 1!");
                                correct1 = false;
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("You have not entered a number please enter a number!");
                            scanner.nextLine();
                            correct1 = false;
                        }
                    } while (!correct1);
                } else if (option == 3) {
                    System.out.println("These channels are inactive");
                    for (Channels channel : channelsList) {
                        if (channel.getStatus().equals("Inactive")) {
                            System.out.println(channel.getName());
                        }
                    }

                    do {
                        correct1 = true;
                        try {
                            System.out.println("\nPress 1 to return to the selection");
                            option = scanner.nextInt();
                            scanner.nextLine();
                            if (option == 1) {
                                correct = false;
                            } else if (option <= 1 || option >= 1) {
                                System.out.println("Please enter number 1!");
                                correct1 = false;
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("You have not entered a number please enter a number!");
                            scanner.nextLine();
                            correct1 = false;
                        }
                    } while (!correct1);
                } else if (option == 4) {

                    do {
                        correct1 = true;
                        try {
                    Integer counter = 0;
                    System.out.println("Pick a channel you want to change");
                    for (Channels channel : channelsList) {
                        counter += 1;
                        System.out.println(counter + ")" + channel.getName());
                    }
                    option = scanner.nextInt();
                    scanner.nextLine();
                            if (option <= 0 || option >= 11) {
                                System.out.println("Please enter number between 1 and 10!");
                                correct1 = false;
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("You have not entered a number please enter a number!");
                            scanner.nextLine();
                            correct1 = false;
                        }
                    } while (!correct1);



                    channelsList.get(option - 1).changeStatus();

                    System.out.println("Channel " + (option) + " is now set to:" + channelsList.get(option - 1).getStatus());

                do {
                    correct1 = true;
                    try {

                        System.out.println("\nPress 1 to return to the selection");
                        option = scanner.nextInt();
                        scanner.nextLine();
                        if (option == 1) {
                            correct = false;
                        } else if (option <= 1 || option >= 1) {
                            System.out.println("Please enter number 1!");
                            correct1 = false;
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("You have not entered a number please enter a number!");
                        scanner.nextLine();
                        correct1 = false;
                    }
                } while (!correct1);
            }

                else if (option==5) {
                    System.exit(5);
                }

                else if(option <=1 || option >=5){
                    System.out.println("Please enter a number between 1 and 5!");
                    correct=false;
                }

            } catch (InputMismatchException ex) {
                System.out.println("You have not entered a number please enter a number!");
                scanner.nextLine();
                correct=false;
            }
        }while(!correct);
    }
    private static void readChannels(List<Channels> channelsList) {
        File fileChannels = new File("dat/channels.txt");
        if (fileChannels.exists()) {

            try (FileReader channelReader = new FileReader(fileChannels);
                 BufferedReader lineReader = new BufferedReader(channelReader)) {
                String line;
                while ((line = lineReader.readLine()) != null) {
                    Integer id = Integer.parseInt(line);
                    String name = lineReader.readLine();
                    String status = lineReader.readLine();
                    Channels newChannel = new Channels(id,name,status);
                    channelsList.add(newChannel);
                }
            } catch (FileNotFoundException e) {
                System.out.println("The file does not exist!");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

