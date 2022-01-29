/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/
def call(name, paso){
     if (paso == "1"){
        // stage("Paso 1:Leer mi Mensaje"){
            echo "Este es mi mensaje: '${name}'"
        // }
     }

     if(paso =="2"){
    //      stage("Paso 1:Responder mi Mensaje"){
             echo "Responder mi mensaje: '${name}'"
    //     }
     }    
	
	nextVersionFromGit()
	

}


def nextVersionFromGit() {
    def latestVersion = sh(returnStdout: true, script: 'git describe --tags --abbrev=0 --match *.*.* 2> /dev/null || echo 0.0.0').trim()
    def (major, minor, patch) = latestVersion.tokenize('.').collect { it.toInteger() }
    def nextVersion
		
 def scope = 'patch'
		
    switch (scope) {
        case 'major':
            nextVersion = "${major + 1}.0.0"
            break
        case 'minor':
            nextVersion = "${major}.${minor + 1}.0"
            break
        case 'patch':
            nextVersion = "${major}.${minor}.${patch + 1}"
            break
    }
    nextVersion
}
