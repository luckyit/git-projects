package pl.luckyit.test.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import pl.luckyit.test.controller.GitRepoController;
import pl.luckyit.test.model.transport.ProjectDTO;
import pl.luckyit.test.service.GitService;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lucjan.Kornacki on 2018-06-13.
 */

@RestController
@RequestMapping("/repo/git")
public class GitRepoControllerImpl implements GitRepoController{

    private static final Logger logger = LoggerFactory.getLogger(GitRepoControllerImpl.class);

    @Autowired
    private GitService gitService;

    @Override
    @GetMapping(value ="/projects/{user}")
    public List<ProjectDTO> getGitProjectsByUser(@PathVariable("user") String user, @RequestParam(required=false) Boolean actual, @RequestParam(required=false) String sort) {
        try {
            return gitService.getProjectsByUser(user, actual, sort);
        }catch(HttpClientErrorException e){
            logger.debug(MessageFormat.format("getProjectsByUser(user:{0},actual:{1},sort:{2})", user, actual, sort), e);
            return Collections.emptyList();
        }
    }

}
