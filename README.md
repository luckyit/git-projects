# git-projects

**1. Release build**
>mvn clean install -Prelease-win

* outputDirectory: git-projects-rest\target\release-win
* packet outputDirectory: git-projects-rest\target\packet-release-win


**2. Users configuration**

Copy the **users.yml** file from **packet-git-projects-rest-[version]** to the directory **[user.home]/git-projects/conf**


**3. Run application**
>java -jar git-projects-rest-[version].jar


**4. REST api**

* List user repositories

  List public repositories for the specified user.

  >GET repo/git/projects/:username

  Parameters: 
  * **actual**, type:boolean
  * **sort**, type:string [dsc, asc]
