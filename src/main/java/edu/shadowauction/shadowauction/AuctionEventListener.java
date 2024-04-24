package edu.shadowauction.shadowauction;

public interface AuctionEventListener {
    void onNewBid(int newBid);
    void onTimerUpdate(String timeString);

    void onLastBidderUpdate(String lastBidder);

    void onChatMessage(String chatMessage, String username);

}

