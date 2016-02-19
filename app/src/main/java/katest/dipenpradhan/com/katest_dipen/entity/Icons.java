package katest.dipenpradhan.com.katest_dipen.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "small",
        "compact",
        "large",
        "email"
})
public class Icons {

    @JsonProperty("small")
    private String small;
    @JsonProperty("compact")
    private String compact;
    @JsonProperty("large")
    private String large;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The small
     */
    @JsonProperty("small")
    public String getSmall() {
        return small;
    }

    /**
     * @param small The small
     */
    @JsonProperty("small")
    public void setSmall(String small) {
        this.small = small;
    }

    /**
     * @return The compact
     */
    @JsonProperty("compact")
    public String getCompact() {
        return compact;
    }

    /**
     * @param compact The compact
     */
    @JsonProperty("compact")
    public void setCompact(String compact) {
        this.compact = compact;
    }

    /**
     * @return The large
     */
    @JsonProperty("large")
    public String getLarge() {
        return large;
    }

    /**
     * @param large The large
     */
    @JsonProperty("large")
    public void setLarge(String large) {
        this.large = large;
    }

    /**
     * @return The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}