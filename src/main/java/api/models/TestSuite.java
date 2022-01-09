package api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestSuite {
    Integer id;
    String title;
    String description;
    String precondition;
    @SerializedName("parent_id")
    Integer parentId;
}