package pl.luckyit.test.service;

import pl.luckyit.test.model.transport.ProjectDTO;
import java.util.List;

/**
 * Created by Lucjan.Kornacki on 2018-03-13.
 */
public interface GitService {

    /**
     * List of user projects
     *
     * @param user name of user
     * @param actual flag of actuality of the project
     * @param sort direction of sorting
     * @return list of projects
     */
    List<ProjectDTO> getProjectsByUser(String user, Boolean actual, String sort);
}
