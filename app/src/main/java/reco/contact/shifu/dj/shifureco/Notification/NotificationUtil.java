package reco.contact.shifu.dj.shifureco.Notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;

import java.util.List;

import reco.contact.shifu.dj.circularimage.DrawableProvider;
import reco.contact.shifu.dj.circularimage.TextDrawable;
import reco.contact.shifu.dj.shifureco.DO.RecotypeDO;
import reco.contact.shifu.dj.shifureco.MainActivity;
import reco.contact.shifu.dj.shifureco.R;

/**
 * Created by deepanshjain on 12/11/15.
 */
public class NotificationUtil {


    public static void showSuggestionOne(Context context, RemoteViews remoteViews, RecotypeDO recotypeDO) {
        String name = recotypeDO.getName();
        remoteViews.setImageViewBitmap(R.id.notificationSuggestOneImageButton, getRoundBitmapForPlaceHolder(context, name));
        remoteViews.setTextViewText(R.id.notificationSuggestOneTextView, name);
        if (recotypeDO.getType() == 1) {
            remoteViews.setViewVisibility(R.id.notificationSuggestOneSubImageButton, View.VISIBLE);
        } else {
            remoteViews.setViewVisibility(R.id.notificationSuggestOneSubImageButton, View.INVISIBLE);
        }
//        PendingIntent pendingIntent = setActionOpenPhoneBook(context, remoteViews, recotypeDO, 15001, "1", isLocation);
//        remoteViews.setOnClickPendingIntent(R.id.notificationSuggestOneRelativeLayout, pendingIntent);
//        remoteViews.setOnClickPendingIntent(R.id.notificationSuggestOneImageButton, pendingIntent);
    }


// Suggestion Notification UI

    public static void showSuggestionTwo(Context context, RemoteViews remoteViews, RecotypeDO recotypeDO) {
        String name = recotypeDO.getName();
        remoteViews.setImageViewBitmap(R.id.notificationSuggestSecondImageButton, getRoundBitmapForPlaceHolder(context, name));
        remoteViews.setTextViewText(R.id.notificationSuggestSecondTextView, name);
        if (recotypeDO.getType() == 1) {
            remoteViews.setViewVisibility(R.id.notificationSuggestSecondSubImageButton, View.VISIBLE);
        } else {
            remoteViews.setViewVisibility(R.id.notificationSuggestSecondSubImageButton, View.INVISIBLE);
        }
//        PendingIntent pendingIntent = setActionOpenPhoneBook(context, remoteViews, getContactInfoDo, 15002, "2", isLocation);
//        remoteViews.setOnClickPendingIntent(R.id.notificationSuggestSecondRelativeLayout, pendingIntent);
//        remoteViews.setOnClickPendingIntent(R.id.notificationSuggestSecondImageButton, pendingIntent);
    }

    public static void showSuggestionThree(Context context, RemoteViews remoteViews, RecotypeDO recotypeDO) {
        String name = recotypeDO.getName();
        remoteViews.setImageViewBitmap(R.id.notificationSuggestThirdImageButton, getRoundBitmapForPlaceHolder(context, name));
        remoteViews.setTextViewText(R.id.notificationSuggestThirdTextView, name);
        if (recotypeDO.getType() == 1) {
            remoteViews.setViewVisibility(R.id.notificationSuggestThirdSubImageButton, View.VISIBLE);
            //remoteViews.setImageViewResource(R.id.notificationSuggestThirdSubImageButton, subImage);

        } else {
            remoteViews.setViewVisibility(R.id.notificationSuggestThirdSubImageButton, View.INVISIBLE);
        }
//        PendingIntent pendingIntent = setActionOpenPhoneBook(context, remoteViews, getContactInfoDo, 15003, "3", isLocation);
//        remoteViews.setOnClickPendingIntent(R.id.notificationSuggestThirdRelativeLayout, pendingIntent);
//        remoteViews.setOnClickPendingIntent(R.id.notificationSuggestThirdImageButton, pendingIntent);
    }

    private static Bitmap getRoundBitmapForPlaceHolder(Context context, String name) {
        DrawableProvider drawableProvider = new DrawableProvider(context);
        TextDrawable drawable = drawableProvider.getRound24(String.valueOf(name.charAt(0)));
        Bitmap mutableBitmap = Bitmap.createBitmap(150, 150, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mutableBitmap);
        drawable.setBounds(0, 0, 150, 150);
        drawable.draw(canvas);
        return mutableBitmap;
    }

//
//    private static PendingIntent setActionOpenPhoneBook(Context context, RemoteViews remoteViews, GetContactInfoDo getContactInfoDo, int codeId,
//                                                        String recoType, boolean isLocation) {
//
//        Intent openPhoneBook = new Intent(context, SuggestNotificationTransferActivity.class);
//        openPhoneBook.putExtra(GeneralConstants.EXTRA_STRING, String.valueOf(getContactInfoDo.getContactId()));
//        openPhoneBook.putExtra(GeneralConstants.EXTRA_STRING_2, getContactInfoDo.getContent());
//        openPhoneBook.putExtra(GeneralConstants.INTENT_TYPE, recoType);
//        openPhoneBook.putExtra(GeneralConstants.STATUS, String.valueOf(getContactInfoDo.getPriority()));
//        openPhoneBook.putExtra(GeneralConstants.EXTRA_PARAM_3, String.valueOf(isLocation));
//        return PendingIntent.getActivity(context, codeId, openPhoneBook, PendingIntent.FLAG_UPDATE_CURRENT);
//
//    }

    /**
     * Notification Currently show CPA and on click will open current tile on
     * home screen
     *
     * @param context Context
     * @param getContactInfoDos
     */
    public void showSuggestNotification(Context context, List<RecotypeDO> getContactInfoDos) {

        Notification foregroundNote = null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.noitifcation_suggest);

        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), R.layout.notification_persist);
        remoteViews2.setTextViewText(R.id.notificationPersistHeading, context.getString(R.string.app_name));

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 1498, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.notificationPersistAddReminder, resultPendingIntent);
        remoteViews2.setOnClickPendingIntent(R.id.notificationPersistAddReminder, resultPendingIntent);

        Intent settingsIntent = new Intent(context, MainActivity.class);
        PendingIntent settingsPendingIntent = PendingIntent.getActivity(context, 1499, settingsIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.notificationPersistSettings, settingsPendingIntent);
        remoteViews2.setOnClickPendingIntent(R.id.notificationPersistSettings, settingsPendingIntent);


        int count = getContactInfoDos.size();
        switch (count) {
            case 1:
                NotificationUtil.showSuggestionThree(context, remoteViews, getContactInfoDos.get(0));
                remoteViews.setViewVisibility(R.id.notificationSuggestThirdRelativeLayout, View.VISIBLE);
                remoteViews.setViewVisibility(R.id.notificationSuggestSecondRelativeLayout, View.INVISIBLE);
                remoteViews.setViewVisibility(R.id.notificationSuggestOneRelativeLayout, View.INVISIBLE);

                break;
            case 2:
                NotificationUtil.showSuggestionThree(context, remoteViews, getContactInfoDos.get(1));
                NotificationUtil.showSuggestionTwo(context, remoteViews, getContactInfoDos.get(0));
                remoteViews.setViewVisibility(R.id.notificationSuggestThirdRelativeLayout, View.VISIBLE);
                remoteViews.setViewVisibility(R.id.notificationSuggestSecondRelativeLayout, View.VISIBLE);
                remoteViews.setViewVisibility(R.id.notificationSuggestOneRelativeLayout, View.INVISIBLE);
                break;
            default:
                NotificationUtil.showSuggestionOne(context, remoteViews, getContactInfoDos.get(0));
                NotificationUtil.showSuggestionTwo(context, remoteViews, getContactInfoDos.get(1));
                NotificationUtil.showSuggestionThree(context, remoteViews, getContactInfoDos.get(2));
                remoteViews.setViewVisibility(R.id.notificationSuggestThirdRelativeLayout, View.VISIBLE);
                remoteViews.setViewVisibility(R.id.notificationSuggestSecondRelativeLayout, View.VISIBLE);
                remoteViews.setViewVisibility(R.id.notificationSuggestOneRelativeLayout, View.VISIBLE);
                break;
        }

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1500, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.shifu_notification)
                .setContent(remoteViews).setPriority(Notification.PRIORITY_HIGH).setOngoing(true).setContentIntent(pendingIntent);

        foregroundNote = mBuilder.build();
        foregroundNote.contentView = remoteViews2;
        foregroundNote.bigContentView = remoteViews;

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, foregroundNote);
    }

}

