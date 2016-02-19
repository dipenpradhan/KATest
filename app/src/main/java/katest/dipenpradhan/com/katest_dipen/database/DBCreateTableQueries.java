package katest.dipenpradhan.com.katest_dipen.database;

import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_ABSOLUTE_URL;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_CATEGORY;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_DESCRIPTION;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_HIDE_CONTEXT;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_ICON_LARGE;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_ICON_SMALL;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_ICON_SRC;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_ID;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_IS_OWNED;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_IS_RETIRED;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_NAME;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_POINTS;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_RELATIVE_URL;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_SAFE_DESC;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_SLUG;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.BADGE_USER_BADGES;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.CAT_DESC;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.CAT_ICON_LARGE;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.CAT_ICON_MED;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.CAT_ICON_SRC;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.CAT_ID;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.CAT_TYPE;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.TABLE_BADGE;
import static katest.dipenpradhan.com.katest_dipen.database.DBConstants.TABLE_CATEGORY;

public class DBCreateTableQueries {

    private static final String TEXT = " TEXT, ";
    private static final String INTEGER = " INTEGER, ";
    private static final String INTEGER_AUTO_INC = " INTEGER PRIMARY KEY AUTOINCREMENT, ";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS";
    private static final String CREATE_VIEW = "CREATE VIEW IF NOT EXISTS";

    static final String CREATE_TABLE_BADGES =
            CREATE_TABLE + " " + TABLE_BADGE + " ( "
                    + BADGE_ID + INTEGER_AUTO_INC
                    + BADGE_ICON_SRC + TEXT
                    + BADGE_HIDE_CONTEXT + INTEGER
                    + BADGE_DESCRIPTION + TEXT
                    + BADGE_RELATIVE_URL + TEXT
                    + BADGE_ABSOLUTE_URL + TEXT
                    + BADGE_USER_BADGES + TEXT
                    + BADGE_IS_OWNED + INTEGER
                    + BADGE_CATEGORY + INTEGER
                    + BADGE_POINTS + TEXT
                    + BADGE_IS_RETIRED + INTEGER
                    + BADGE_SAFE_DESC + TEXT
                    + BADGE_SLUG + TEXT
                    + BADGE_NAME + TEXT
                    + BADGE_ICON_SMALL + TEXT
                    + BADGE_ICON_LARGE + " TEXT )";

    static final String CREATE_TABLE_CATEGORY =
            CREATE_TABLE + " " + TABLE_CATEGORY + " ( "
                    + CAT_ID + INTEGER
                    + CAT_DESC + TEXT
                    + CAT_ICON_SRC + TEXT
                    + CAT_ICON_LARGE + TEXT
                    + CAT_ICON_MED + TEXT
                    + CAT_TYPE + " TEXT )";

}
