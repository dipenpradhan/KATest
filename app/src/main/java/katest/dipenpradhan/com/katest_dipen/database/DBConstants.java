package katest.dipenpradhan.com.katest_dipen.database;

import android.net.Uri;
import android.provider.BaseColumns;

import katest.dipenpradhan.com.katest_dipen.BuildConfig;
import katest.dipenpradhan.com.katest_dipen.entity.Badge;
import katest.dipenpradhan.com.katest_dipen.entity.Category;


public final class DBConstants implements BaseColumns {

    private DBConstants() {
    }

    public static final String SCHEME = "content";
    public static final String AUTHORITY = BuildConfig.APPLICATION_ID;
    public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

    public static final String DATABASE_NAME = "ka.sqlite";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CATEGORY = Category.class.getSimpleName();
    public static final String CAT_ID = _ID;
    public static final String CAT_ICON_SRC = "icon_src";
    public static final String CAT_TYPE = "type_label";
    public static final String CAT_DESC = "description";
    public static final String CAT_ICON_LARGE = "large_icon_src";
    public static final String CAT_ICON_MED = "medium_icon_src";

    public static final String TABLE_BADGE = Badge.class.getSimpleName();
    public static final String BADGE_ID = _ID;
    public static final String BADGE_ICON_SRC = "icon_src";
    public static final String BADGE_HIDE_CONTEXT = "hide_context";
    public static final String BADGE_DESCRIPTION = "description";
    public static final String BADGE_RELATIVE_URL = "relative_url";
    public static final String BADGE_ABSOLUTE_URL = "absolute_url";
    public static final String BADGE_USER_BADGES = "user_badges";
    public static final String BADGE_IS_OWNED = "is_owned";
    public static final String BADGE_CATEGORY = "badge_category";
    public static final String BADGE_POINTS = "points";
    public static final String BADGE_IS_RETIRED = "is_retired";
    public static final String BADGE_SAFE_DESC = "safe_extended_description";
    public static final String BADGE_SLUG = "slug";
    public static final String BADGE_NAME = "name";
    public static final String BADGE_ICON_SMALL = "icon_small";
    public static final String BADGE_ICON_LARGE = "icon_large";


}