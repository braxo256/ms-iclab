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
	
	def repoUrl = env.GIT_URL
def key = repoUrl.tokenize('/')[3]
def slug = repoUrl.tokenize('/')[4]
slug = slug.substring(0, slug.lastIndexOf('.')) //Remove .git
echo "The projectKey is: ${key}"
echo "The repositorySlug is: ${slug}"
}
