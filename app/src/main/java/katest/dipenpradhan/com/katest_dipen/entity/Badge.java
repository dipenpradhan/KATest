package katest.dipenpradhan.com.katest_dipen.entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

import katest.dipenpradhan.com.katest_dipen.database.DBConstants;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "icon_src",
        "hide_context",
        "description",
        "relative_url",
        "icons",
        "absolute_url",
        "user_badges",
        "translated_safe_extended_description",
        "translated_description",
        "is_owned",
        "badge_category",
        "points",
        "is_retired",
        "safe_extended_description",
        "slug",
        "name"
})
public class Badge implements Parcelable {

    @JsonIgnore
    private Integer id;

    @JsonProperty("icon_src")
    private String iconSrc;
    @JsonProperty("hide_context")
    private Boolean hideContext;
    @JsonProperty("description")
    private String description;
    @JsonProperty("relative_url")
    private String relativeUrl;
    @JsonProperty("icons")
    private Icons icons;
    @JsonProperty("absolute_url")
    private String absoluteUrl;
    @JsonProperty("user_badges")
    private Object userBadges;
    @JsonProperty("translated_safe_extended_description")
    private String translatedSafeExtendedDescription;
    @JsonProperty("translated_description")
    private String translatedDescription;
    @JsonProperty("is_owned")
    private Boolean isOwned;
    @JsonProperty("badge_category")
    private Integer badgeCategory;
    @JsonProperty("points")
    private Integer points;
    @JsonProperty("is_retired")
    private Boolean isRetired;
    @JsonProperty("safe_extended_description")
    private String safeExtendedDescription;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Badge() {
    }

    public Badge(Parcel parcel) {
        setIconSrc(parcel.readString());
        setHideContext(parcel.readInt() == 1);
        setDescription(parcel.readString());
        setRelativeUrl(parcel.readString());
        setAbsoluteUrl(parcel.readString());
        setIsOwned(parcel.readInt() == 1);
        setBadgeCategory(parcel.readInt());
        setPoints(parcel.readInt());
        setIsRetired(parcel.readInt() == 1);
        setSafeExtendedDescription(parcel.readString());
        setSlug(parcel.readString());
        setName(parcel.readString());
        Icons icons = new Icons();
        icons.setSmall(parcel.readString());
        icons.setLarge(parcel.readString());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The iconSrc
     */
    @JsonProperty("icon_src")
    public String getIconSrc() {
        return iconSrc;
    }

    /**
     * @param iconSrc The icon_src
     */
    @JsonProperty("icon_src")
    public void setIconSrc(String iconSrc) {
        this.iconSrc = iconSrc;
    }

    /**
     * @return The hideContext
     */
    @JsonProperty("hide_context")
    public Boolean getHideContext() {
        return hideContext;
    }

    /**
     * @param hideContext The hide_context
     */
    @JsonProperty("hide_context")
    public void setHideContext(Boolean hideContext) {
        this.hideContext = hideContext;
    }

    /**
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The relativeUrl
     */
    @JsonProperty("relative_url")
    public String getRelativeUrl() {
        return relativeUrl;
    }

    /**
     * @param relativeUrl The relative_url
     */
    @JsonProperty("relative_url")
    public void setRelativeUrl(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }

    /**
     * @return The icons
     */
    @JsonProperty("icons")
    public Icons getIcons() {
        return icons;
    }

    /**
     * @param icons The icons
     */
    @JsonProperty("icons")
    public void setIcons(Icons icons) {
        this.icons = icons;
    }

    /**
     * @return The absoluteUrl
     */
    @JsonProperty("absolute_url")
    public String getAbsoluteUrl() {
        return absoluteUrl;
    }

    /**
     * @param absoluteUrl The absolute_url
     */
    @JsonProperty("absolute_url")
    public void setAbsoluteUrl(String absoluteUrl) {
        this.absoluteUrl = absoluteUrl;
    }

    /**
     * @return The userBadges
     */
    @JsonProperty("user_badges")
    public Object getUserBadges() {
        return userBadges;
    }

    /**
     * @param userBadges The user_badges
     */
    @JsonProperty("user_badges")
    public void setUserBadges(Object userBadges) {
        this.userBadges = userBadges;
    }

    /**
     * @return The translatedSafeExtendedDescription
     */
    @JsonProperty("translated_safe_extended_description")
    public String getTranslatedSafeExtendedDescription() {
        return translatedSafeExtendedDescription;
    }

    /**
     * @param translatedSafeExtendedDescription The translated_safe_extended_description
     */
    @JsonProperty("translated_safe_extended_description")
    public void setTranslatedSafeExtendedDescription(String translatedSafeExtendedDescription) {
        this.translatedSafeExtendedDescription = translatedSafeExtendedDescription;
    }

    /**
     * @return The translatedDescription
     */
    @JsonProperty("translated_description")
    public String getTranslatedDescription() {
        return translatedDescription;
    }

    /**
     * @param translatedDescription The translated_description
     */
    @JsonProperty("translated_description")
    public void setTranslatedDescription(String translatedDescription) {
        this.translatedDescription = translatedDescription;
    }

    /**
     * @return The isOwned
     */
    @JsonProperty("is_owned")
    public Boolean getIsOwned() {
        return isOwned;
    }

    /**
     * @param isOwned The is_owned
     */
    @JsonProperty("is_owned")
    public void setIsOwned(Boolean isOwned) {
        this.isOwned = isOwned;
    }

    /**
     * @return The badgeCategory
     */
    @JsonProperty("badge_category")
    public Integer getBadgeCategory() {
        return badgeCategory;
    }

    /**
     * @param badgeCategory The badge_category
     */
    @JsonProperty("badge_category")
    public void setBadgeCategory(Integer badgeCategory) {
        this.badgeCategory = badgeCategory;
    }

    /**
     * @return The points
     */
    @JsonProperty("points")
    public Integer getPoints() {
        return points;
    }

    /**
     * @param points The points
     */
    @JsonProperty("points")
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * @return The isRetired
     */
    @JsonProperty("is_retired")
    public Boolean getIsRetired() {
        return isRetired;
    }

    /**
     * @param isRetired The is_retired
     */
    @JsonProperty("is_retired")
    public void setIsRetired(Boolean isRetired) {
        this.isRetired = isRetired;
    }

    /**
     * @return The safeExtendedDescription
     */
    @JsonProperty("safe_extended_description")
    public String getSafeExtendedDescription() {
        return safeExtendedDescription;
    }

    /**
     * @param safeExtendedDescription The safe_extended_description
     */
    @JsonProperty("safe_extended_description")
    public void setSafeExtendedDescription(String safeExtendedDescription) {
        this.safeExtendedDescription = safeExtendedDescription;
    }

    /**
     * @return The slug
     */
    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    /**
     * @param slug The slug
     */
    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.BADGE_ICON_SRC, getIconSrc());
        contentValues.put(DBConstants.BADGE_HIDE_CONTEXT, getHideContext());
        contentValues.put(DBConstants.BADGE_DESCRIPTION, getDescription());
        contentValues.put(DBConstants.BADGE_RELATIVE_URL, getRelativeUrl());
        contentValues.put(DBConstants.BADGE_ABSOLUTE_URL, getAbsoluteUrl());
        contentValues.put(DBConstants.BADGE_IS_OWNED, getIsOwned() ? 1 : 0);
        contentValues.put(DBConstants.BADGE_CATEGORY, getBadgeCategory());
        contentValues.put(DBConstants.BADGE_POINTS, getPoints());
        contentValues.put(DBConstants.BADGE_IS_RETIRED, getIsRetired() ? 1 : 0);
        contentValues.put(DBConstants.BADGE_SAFE_DESC, getSafeExtendedDescription());
        contentValues.put(DBConstants.BADGE_SLUG, getSlug());
        contentValues.put(DBConstants.BADGE_NAME, getName());
        if (getIcons() != null) {
            contentValues.put(DBConstants.BADGE_ICON_SMALL, getIcons().getSmall());
            contentValues.put(DBConstants.BADGE_ICON_LARGE, getIcons().getLarge());
        }

        return contentValues;
    }

    public static Badge fromCursor(Cursor c) {
        if (c == null || c.getColumnCount() == 0 || c.getCount() == 0) {
            return null;
        }

        Badge badge = new Badge();
        if (c.getColumnIndex(DBConstants.BADGE_ID) != -1) {
            badge.setId(c.getInt(c.getColumnIndex(DBConstants.BADGE_ID)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_ICON_SRC) != -1) {
            badge.setIconSrc(c.getString(c.getColumnIndex(DBConstants.BADGE_ICON_SRC)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_HIDE_CONTEXT) != -1) {
            badge.setHideContext(c.getInt(c.getColumnIndex(DBConstants.BADGE_HIDE_CONTEXT)) == 1);
        }
        if (c.getColumnIndex(DBConstants.BADGE_DESCRIPTION) != -1) {
            badge.setDescription(c.getString(c.getColumnIndex(DBConstants.BADGE_DESCRIPTION)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_RELATIVE_URL) != -1) {
            badge.setRelativeUrl(c.getString(c.getColumnIndex(DBConstants.BADGE_RELATIVE_URL)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_ABSOLUTE_URL) != -1) {
            badge.setAbsoluteUrl(c.getString(c.getColumnIndex(DBConstants.BADGE_ABSOLUTE_URL)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_IS_OWNED) != -1) {
            badge.setIsOwned(c.getInt(c.getColumnIndex(DBConstants.BADGE_IS_OWNED)) == 1);
        }
        if (c.getColumnIndex(DBConstants.BADGE_CATEGORY) != -1) {
            badge.setBadgeCategory(c.getInt(c.getColumnIndex(DBConstants.BADGE_CATEGORY)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_POINTS) != -1) {
            badge.setPoints(c.getInt(c.getColumnIndex(DBConstants.BADGE_POINTS)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_IS_RETIRED) != -1) {
            badge.setIsRetired(c.getInt(c.getColumnIndex(DBConstants.BADGE_IS_RETIRED)) == 1);
        }
        if (c.getColumnIndex(DBConstants.BADGE_SAFE_DESC) != -1) {
            badge.setSafeExtendedDescription(c.getString(c.getColumnIndex(DBConstants.BADGE_SAFE_DESC)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_SLUG) != -1) {
            badge.setSlug(c.getString(c.getColumnIndex(DBConstants.BADGE_SLUG)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_NAME) != -1) {
            badge.setName(c.getString(c.getColumnIndex(DBConstants.BADGE_NAME)));
        }

        Icons icons = new Icons();

        if (c.getColumnIndex(DBConstants.BADGE_ICON_SMALL) != -1) {
            icons.setSmall(c.getString(c.getColumnIndex(DBConstants.BADGE_ICON_SMALL)));
        }
        if (c.getColumnIndex(DBConstants.BADGE_ICON_LARGE) != -1) {
            icons.setLarge(c.getString(c.getColumnIndex(DBConstants.BADGE_ICON_LARGE)));
        }
        badge.setIcons(icons);

        return badge;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getIconSrc());
        dest.writeInt(getHideContext() ? 1 : 0);
        dest.writeString(getDescription());
        dest.writeString(getRelativeUrl());
        dest.writeString(getAbsoluteUrl());
        dest.writeInt(getIsOwned() ? 1 : 0);
        dest.writeInt(getBadgeCategory());
        dest.writeInt(getPoints());
        dest.writeInt(getIsRetired() ? 1 : 0);
        dest.writeString(getSafeExtendedDescription());
        dest.writeString(getSlug());
        dest.writeString(getName());
        if (getIcons() != null) {
            dest.writeString(getIcons().getSmall());
            dest.writeString(getIcons().getLarge());
        }
    }

    public static final Creator<Badge> CREATOR = new Creator<Badge>() {

        @Override
        public Badge createFromParcel(Parcel source) {
            return new Badge(source);
        }

        @Override
        public Badge[] newArray(int size) {
            return new Badge[0];
        }
    };
}

