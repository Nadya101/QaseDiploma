package api.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Project {
String title;
String code;
String description;
String access;
String group;
}