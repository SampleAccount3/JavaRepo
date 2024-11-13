package org.example;

import java.util.ArrayList;
import java.util.List;

public class ObservableClass {

    private String news;

    List<IChannelAble> channels = new ArrayList<>();

    public void addChannels(ObservableChannel channel) {
        this.channels.add(channel);
    }
    public void removeObserver(ObservableChannel channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for(IChannelAble channelAble: this.channels){
            channelAble.Update(this.news);
        }
    }
}
