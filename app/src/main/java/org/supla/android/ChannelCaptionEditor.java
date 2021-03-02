package org.supla.android;

import android.content.Context;

import org.supla.android.db.Channel;
import org.supla.android.db.DbHelper;
import org.supla.android.db.Location;

public class ChannelCaptionEditor extends CaptionEditor {
    public ChannelCaptionEditor(Context context) {
        super(context);
    }

    @Override
    protected int getTitle() {
        return R.string.channel_name;
    }

    @Override
    protected String getCaption() {
        DbHelper dbH = DbHelper.getInstance(getContext());
        if (dbH!=null) {
            Channel channel = dbH.getChannel(getId());
            if (channel != null && channel.getCaption() != null) {
                return channel.getCaption();
            }
        }
        return "";
    }

    @Override
    protected void applyChanged(String newCaption) {

    }

    @Override
    protected int getHint() {
        return R.string.str_default;
    }
}
