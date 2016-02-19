package katest.dipenpradhan.com.katest_dipen.entity;

import android.content.ContentValues;
import android.database.Cursor;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import katest.dipenpradhan.com.katest_dipen.database.DBConstants;


@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "category",
        "icon_src",
        "type_label",
        "email_icon_src",
        "large_icon_src",
        "compact_icon_src",
        "translated_description",
        "chart_icon_src",
        "medium_icon_src",
        "CATEGORIES",
        "description"
})
public class Category {

    @JsonProperty("category")
    private Integer category;
    @JsonProperty("icon_src")
    private String iconSrc;
    @JsonProperty("type_label")
    private String typeLabel;
    @JsonProperty("email_icon_src")
    private String emailIconSrc;
    @JsonProperty("large_icon_src")
    private String largeIconSrc;
    @JsonProperty("compact_icon_src")
    private String compactIconSrc;
    @JsonProperty("translated_description")
    private String translatedDescription;
    @JsonProperty("chart_icon_src")
    private String chartIconSrc;
    @JsonProperty("medium_icon_src")
    private String mediumIconSrc;
    @JsonProperty("CATEGORIES")
    private List<Integer> CATEGORIES = new ArrayList<Integer>();
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The category
     */
    @JsonProperty("category")
    public Integer getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    @JsonProperty("category")
    public void setCategory(Integer category) {
        this.category = category;
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
     * @return The typeLabel
     */
    @JsonProperty("type_label")
    public String getTypeLabel() {
        return typeLabel;
    }

    /**
     * @param typeLabel The type_label
     */
    @JsonProperty("type_label")
    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    /**
     * @return The emailIconSrc
     */
    @JsonProperty("email_icon_src")
    public String getEmailIconSrc() {
        return emailIconSrc;
    }

    /**
     * @param emailIconSrc The email_icon_src
     */
    @JsonProperty("email_icon_src")
    public void setEmailIconSrc(String emailIconSrc) {
        this.emailIconSrc = emailIconSrc;
    }

    /**
     * @return The largeIconSrc
     */
    @JsonProperty("large_icon_src")
    public String getLargeIconSrc() {
        return largeIconSrc;
    }

    /**
     * @param largeIconSrc The large_icon_src
     */
    @JsonProperty("large_icon_src")
    public void setLargeIconSrc(String largeIconSrc) {
        this.largeIconSrc = largeIconSrc;
    }

    /**
     * @return The compactIconSrc
     */
    @JsonProperty("compact_icon_src")
    public String getCompactIconSrc() {
        return compactIconSrc;
    }

    /**
     * @param compactIconSrc The compact_icon_src
     */
    @JsonProperty("compact_icon_src")
    public void setCompactIconSrc(String compactIconSrc) {
        this.compactIconSrc = compactIconSrc;
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
     * @return The chartIconSrc
     */
    @JsonProperty("chart_icon_src")
    public String getChartIconSrc() {
        return chartIconSrc;
    }

    /**
     * @param chartIconSrc The chart_icon_src
     */
    @JsonProperty("chart_icon_src")
    public void setChartIconSrc(String chartIconSrc) {
        this.chartIconSrc = chartIconSrc;
    }

    /**
     * @return The mediumIconSrc
     */
    @JsonProperty("medium_icon_src")
    public String getMediumIconSrc() {
        return mediumIconSrc;
    }

    /**
     * @param mediumIconSrc The medium_icon_src
     */
    @JsonProperty("medium_icon_src")
    public void setMediumIconSrc(String mediumIconSrc) {
        this.mediumIconSrc = mediumIconSrc;
    }

    /**
     * @return The CATEGORIES
     */
    @JsonProperty("CATEGORIES")
    public List<Integer> getCATEGORIES() {
        return CATEGORIES;
    }

    /**
     * @param CATEGORIES The CATEGORIES
     */
    @JsonProperty("CATEGORIES")
    public void setCATEGORIES(List<Integer> CATEGORIES) {
        this.CATEGORIES = CATEGORIES;
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
        contentValues.put(DBConstants.CAT_ID, getCategory());
        contentValues.put(DBConstants.CAT_ICON_LARGE, getLargeIconSrc());
        contentValues.put(DBConstants.CAT_ICON_MED, getMediumIconSrc());
        contentValues.put(DBConstants.CAT_ICON_SRC, getIconSrc());
        contentValues.put(DBConstants.CAT_TYPE, getTypeLabel());
        contentValues.put(DBConstants.CAT_DESC, getDescription());

        return contentValues;
    }

    public static Category fromCursor(Cursor c) {
        if (c == null || c.getColumnCount() == 0 || c.getCount() == 0) {
            return null;
        }

        Category cat = new Category();
        if (c.getColumnIndex(DBConstants.CAT_ID) != -1) {
            cat.setCategory(c.getInt(c.getColumnIndex(DBConstants.CAT_ID)));
        }
        if (c.getColumnIndex(DBConstants.CAT_DESC) != -1) {
            cat.setDescription(c.getString(c.getColumnIndex(DBConstants.CAT_DESC)));
        }
        if (c.getColumnIndex(DBConstants.CAT_TYPE) != -1) {
            cat.setTypeLabel(c.getString(c.getColumnIndex(DBConstants.CAT_TYPE)));
        }
        if (c.getColumnIndex(DBConstants.CAT_ICON_LARGE) != -1) {
            cat.setLargeIconSrc(c.getString(c.getColumnIndex(DBConstants.CAT_ICON_LARGE)));
        }
        if (c.getColumnIndex(DBConstants.CAT_ICON_MED) != -1) {
            cat.setMediumIconSrc(c.getString(c.getColumnIndex(DBConstants.CAT_ICON_MED)));
        }
        if (c.getColumnIndex(DBConstants.CAT_ICON_SRC) != -1) {
            cat.setIconSrc(c.getString(c.getColumnIndex(DBConstants.CAT_ICON_SRC)));
        }
        return cat;
    }
}