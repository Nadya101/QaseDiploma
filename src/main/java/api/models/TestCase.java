package api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    String description;
    String preconditions;
    String postconditions;
    String title;
    Integer severity;
    Integer priority;
    Integer behavior;
    Integer type;
    Integer layer;
    @SerializedName("is_flaky")
    Integer isFlaky;
    @SerializedName("suite_id")
    Integer suiteId;
    @SerializedName("milestone_id")
    Integer milestoneId;
    Integer automation;
    Integer status;
    String[] attachments;
    Object[] steps;
    String[] tags;
    @SerializedName("custom_field")
    Object customField;
}