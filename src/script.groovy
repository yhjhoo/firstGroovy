println "Hello World"


def x = 42
println x.getClass()
x = "Hello World"
println x.getClass()


x = "World"
println "Hello, $x"


def firstName = "Douglas"
def nameA = "Adams"
println "Hello, ${firstName[0]}. $nameA"

if(firstName){
    println("kkkkkkkkkkkkkkkkkk");
}

def s = """This is
a multiline
string"""


def matcher = "The Hitchhiker's Guide to the Galaxy" =~ /Galaxy/
if (matcher) {
    println "Found the word 'Galaxy'"
}

def helloWorld = {
    println "Hello World"
}

helloWorld()


def power = { int i, int j ->
    return Math.pow(i, j)
}
println power(2, 3)



def say = { what ->
    println what
}
say "Hello World"
say("============= helloWorld =================")




def createGreeter = { name ->
    return {
        def day = new Date().getDay()
        if (day == 0 || day == 6) {
            println "Nice Weekend, $name"
        } else {
            println "Hello, $name"
        }
    }
}
def greetWorld = createGreeter("World")
greetWorld()



def list = [1,1,2,3,5,4]
println list[0] // will print 1

println list[-1] // negative indexes for access from the end of the list, will print out 5


if (4 in list) {
    println "found it"
}

list.each {
    println "numbers in list: " + it
}


def even = list.findAll { it % 2 == 0 }
even.each {
    println it
}

println("222222222222222222222")
def squaredList = list.collect { it * it }
squaredList.each {
    println it
}



def upper = ["Hello", "World"].collect { it.toUpperCase() }
upper.each {
    println it
}

def upper1 = ["Hello", "World"]*.toUpperCase()
upper1.each {
    println it
}



def key = 'Key3'
def aMap = [
        'Key1': 'Value 1', // Put key1 -> Value 1 to the map
        Key2: 'Value 2', // You can also skip the quotes, the key will automatically be a String
        (key): 'Another value' // If you want the key to be the value of a variable, you need to put it in parantheses
]

println aMap['Key1'] // Access the key Key1
println aMap[key] // Access the entry with the value of key variable

println aMap.Key1


aMap.each {
    println "key: " + it.key
    println "value: " + it.value
}

//def deployer = new Deployer()
//deployer.setLanguage("CH")
//println(deployer.language)

class JarUtil implements Serializable{
    def groupId = "me.prince"
    def artifactId = "api-gateway"
    def version = "0.0.1-SNAPSHOT"
    def artifactoryURL = "https://artifactory.prince.me/artifactory"
    def repo_releasse = "libs-dev-local"
    def repo_snapshot = "libs-snapshot-local"
    def extenstion = ".jar"

    String getAbsoluteURl(){
        def repo = version.contains("SNAPSHOT") ? repo_snapshot : repo_releasse

        return artifactoryURL + "/" + repo + "/" + getRelativeURl();
    }

    String getTargetPath(){
        return "target/" + getJarName()
    }

    String getRelativeURl(){
        return (groupId.replaceAll("\\.", "/")
                + "/"
                + artifactId + "/"
                + version + "/"
                + getJarName()
        )
    }

    String getJarName() {
        return artifactId + "-" + version + extenstion
    }
}

def service = new JarUtil()
println(service.getAbsoluteURl() )
println("------------")

println(service.getRelativeURl() )
assert service.getAbsoluteURl() == "https://artifactory.prince.me/artifactory/libs-snapshot-local/me/prince/api-gateway/0.0.1-SNAPSHOT/api-gateway-0.0.1-SNAPSHOT.jar"


//https://artifactory.prince.me/artifactory/libs-snapshot-local/me/prince/api-gateway/0.0.1-SNAPSHOT/api-gateway-0.0.1-SNAPSHOT.jar"
//https://artifactory.prince.me/artifactory/libs-dev-local/me/prince/api-gateway/0.0.1-SNAPSHOT/api-gateway-0.0.1-SNAPSHOT.jar
println("fsd ${service.getJarName()}")


