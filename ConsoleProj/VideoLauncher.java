import java.util.*;

public class VideoLauncher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        String name = "";
        VideoStore store = new VideoStore();

        do {
            System.out.println("MAIN MENU");
            System.out.println("----------");
            System.out.println("1. Add Videos :");
            System.out.println("2. Check Out Video :");
            System.out.println("3. Return Video :");
            System.out.println("4. Receive Rating :");
            System.out.println("5. List Inventory :");
            System.out.println("6. EXIT :");
            System.out.println("Enter your choice (1..6) :");

            try {
                num = sc.nextInt();

                switch (num) {
                    case 1:
                        System.out.println("Enter the name of the video you want to add:");
                        name = sc.next();
                        int addStatus = store.addVideo(name);
                        if (addStatus == 0) {
                            System.out.println("Video \"" + name + "\" added successfully.");
                        } else {
                            System.out.println("Video \"" + name + "\" already exists.");
                        }
                        System.out.println();
                        break;

                    case 2:
                        System.out.println("Enter the name of the video you want to check out:");
                        name = sc.next();
                        int checkOutStatus = store.doCheckOut(name);
                        if (checkOutStatus == 0) {
                            System.out.println("Video \"" + name + "\" checked out successfully.");
                        } else if (checkOutStatus == 1) {
                            System.out.println("Video \"" + name + "\" is already checked out.");
                        } else {
                            System.out.println("Video \"" + name + "\" not found.");
                        }
                        break;

                    case 3:
                        System.out.println("Enter the name of the video you want to return:");
                        name = sc.next();
                        int returnStatus = store.doReturn(name);
                        if (returnStatus == 0) {
                            System.out.println("Video \"" + name + "\" returned successfully.");
                        } else if (returnStatus == 1) {
                            System.out.println("Video \"" + name + "\" is not checked out.");
                        } else {
                            System.out.println("Video \"" + name + "\" not found.");
                        }
                        break;

                    case 4:
                        System.out.println("Enter the name of the video you want to rate:");
                        name = sc.next();
                        System.out.println("Enter the rating for this video (0-10):");
                        if (sc.hasNextInt()) {
                            int rating = sc.nextInt();
                            int ratingStatus = store.receiveRating(name, rating);
                            if (ratingStatus == 0) {
                                System.out.println("Rating \"" + rating + "\" has been mapped to the video \"" + name + "\".");
                            } else if (ratingStatus == -2) {
                                System.out.println("Invalid rating. Please enter a rating between 0 and 10.");
                            } else {
                                System.out.println("Video \"" + name + "\" not found.");
                            }
                        } else {
                            System.out.println("Invalid rating. Please enter a number between 0 and 10.");
                            sc.next(); // Clear the invalid input
                        }
                        break;

                    case 5:
                        store.listInventory();
                        break;

                    case 6:
                        System.out.println("Exiting... Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                sc.next(); // Clear the invalid input
            }
        } while (num != 6);
        sc.close();
    }
}
