class Video {
  String videoName;
  boolean checkout;
  int rating;

  Video(String name) {
      videoName = name;
  }

  public String getName() {
      return videoName;
  }

  public void receiveRating(int rating) {
      this.rating = rating;
  }

  public int getRating() {
      return rating;
  }

  public void doReturn() {
      this.checkout = false;
  }

  public void doCheckout() {
      this.checkout = true;
  }

  public boolean getCheckout() {
      return checkout;
  }
}
