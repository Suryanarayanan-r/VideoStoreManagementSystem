import java.util.*;

public class VideoStore {
    ArrayList<Video> list = new ArrayList<>();

    public int addVideo(String name) {
        for (Video vid : list) {
            if (vid.getName().equals(name)) {
                return -1; // Video already exists
            }
        }
        Video vid = new Video(name);
        list.add(vid);
        return 0; // Success
    }

    public int doCheckOut(String name) {
        for (Video vid : list) {
            if (vid.getName().equals(name)) {
                if (vid.getCheckout()) {
                    return 1; // Video already checked out
                } else {
                    vid.doCheckout();
                    return 0; // Success
                }
            }
        }
        return -1; // Video not found
    }

    public int receiveRating(String name, int rating) {
        if (rating < 0 || rating > 10) {
            return -2; // Rating out of range
        }
        for (Video vid : list) {
            if (vid.getName().equals(name)) {
                vid.receiveRating(rating);
                return 0; // Success
            }
        }
        return -1; // Video not found
    }

    public int doReturn(String name) {
        for (Video vid : list) {
            if (vid.getName().equals(name)) {
                if (!vid.getCheckout()) {
                    return 1; // Video is not checked out
                } else {
                    vid.doReturn();
                    return 0; // Success
                }
            }
        }
        return -1; // Video not found
    }

    public void listInventory() {
        System.out.println("----------------------------------------------");
        System.out.printf("%-10s   | %-20s   | %5s \n", "Video Name", "Checkout Status", "Rating");
        for (Video vid : list) {
            System.out.printf("%-10s   | %-20s   | %5s \n", vid.getName(), vid.getCheckout(), vid.getRating());
        }
        System.out.println("----------------------------------------------");
        System.out.println();
    }
}
