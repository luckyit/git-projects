package pl.luckyit.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import pl.luckyit.test.model.transport.ProjectDTO;
import pl.luckyit.test.service.GitService;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Lucjan.Kornacki on 2018-06-13.
 */
@Service
public class GitServiceImpl implements GitService {

    private static final String DEFAULT_SORT="asc";

    @Autowired
    private RestTemplate template;

    @Value("${github.url}")
    private String githubUrl;

    @PostConstruct
    private void init(){
        githubUrl +="/users/{0}/repos?type=owner&sort=name&direction={1}";
    }

    @Override
    public List<ProjectDTO> getProjectsByUser(String user, Boolean actual, String sort){

        if(StringUtils.isEmpty(sort))sort=DEFAULT_SORT;
        String path = MessageFormat.format(githubUrl, user, sort);

        ResponseEntity<ProjectDTO[]> entity = template.getForEntity(path, ProjectDTO[].class);
        if (actual != null) {
            return Arrays.stream(entity.getBody()).filter(item -> item.isActual() == actual).collect(Collectors.toList());
        } else {
            return Arrays.asList(entity.getBody());
        }

    }
}
