package pl.luckyit.test.controller;

import pl.luckyit.test.model.transport.ProjectDTO;
import java.util.List;

/**
 * Created by Lucjan.Kornacki on 2018-06-13.
 */
public interface GitRepoController {

    /**
     * List of user projects
     *
     * @param user name of user
     * @param actual flag of actuality of the project
     * @param sort direction of sorting
     * @return list of projects
     */
    List<ProjectDTO> getGitProjectsByUser(String user, Boolean actual, String sort);

}
