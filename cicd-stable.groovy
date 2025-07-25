node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/libyamlport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/libyamlport.git'), string(name: 'PORT_DESCRIPTION', value: 'LibYAML is a YAML parser and emitter library' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
