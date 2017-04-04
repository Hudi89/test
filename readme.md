# Free VPS

Amazon:
https://aws.amazon.com/free/

DigitalOcean:
https://education.github.com/pack

# Installing Jenkins 

https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+on+Ubuntu

# Gradle install

http://linuxg.net/how-to-install-gradle-2-1-on-ubuntu-14-10-ubuntu-14-04-ubuntu-12-04-and-derivatives/

## Gradle tutorials 

https://www.tutorialspoint.com/gradle/gradle_build_a_java_project.htm

https://docs.gradle.org/current/userguide/tutorial_using_tasks.html

https://docs.gradle.org/current/userguide/userguide.html

# Github hook url

http://[Your server url and port]/github-webhook/
 
# Idea problem fixes

http://stackoverflow.com/questions/36435598/gradle-not-downloading-dependencies-in-intellij-idea

http://stackoverflow.com/questions/35536013/intellij-build-error-context-mismatch/37418429#37418429

From https://youtrack.jetbrains.com/issue/IDEA-162389:
Anton Shaikin  03 Dec 2016, 07:58
For me the solution was to add "org.gradle.java.home=<path_to_java_home>" to USER_HOME/.gradle/gradle.properties
This is clearly a bug, which started manifesting itself since I upgraded to IntelliJ 2016.3 I think it may have something to do with the fact, that now IntelliJ uses "Gradle-aware Make".
