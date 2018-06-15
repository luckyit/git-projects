package pl.luckyit.test.model.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by Lucjan.Kornacki on 2018-03-14.
 */
public class ProjectDTO {

    @JsonProperty("name")
    private String repoName;
    @JsonProperty("language")
    private String programmingLanguage;
    @JsonProperty("created_at")
    private LocalDateTime createDate;
    @JsonProperty("updated_at")
    private LocalDateTime modificationDate;

    public boolean isActual() {
        return createDate.until( modificationDate, ChronoUnit.MONTHS)<4;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }
}
