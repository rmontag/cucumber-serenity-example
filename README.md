0) Aufruf mit "mvn clean package verify"

1) Firefox-Driver

Während beim 'serenity-example' mit @RunWith(SerenityRunner.class) eine einfache Annotation

@Managed(driver = "firefox")
	WebDriver browser;
	
langt, damit beim Testlauf der Firefox verwendet wird, klappt das hier bei dem CucumberWithSerenity-Runner nicht!

@RunWith(CucumberWithSerenity.class) mit @Managed liefert

"Could not instantiate class org.openqa.selenium.firefox.FirefoxDriver"

Man muss tatsächlich folgendes machen:
- auf "https://github.com/mozilla/geckodriver/releases" sich die aktuelle Version von "geckodriver.exe" holen
- und lokal auf der Platte extrahieren, z.B. "C:\devtools\geckodriver.exe"
- dann im pom.xml für das Failsafe-Plugin diesen Pfad zusätzlich bei den System Properties mit angeben:

					<systemProperties>
						<!-- you can pass as parameter webdriver type via Jenkins or TeamCity -->
						<webdriver.driver>${webdriver.driver}</webdriver.driver>
						<webdriver.gecko.driver>C:\devtools\geckodriver.exe</webdriver.gecko.driver>
					</systemProperties>

2) Page-Navigation

Ich habe noch nicht verstanden wie es Serenity schafft, die ResultPage (extends PageObject) so zu instanziieren, dass das tatsächlich die "richtige" Webeite ist...

 3) serenity.properties
 
 Werden für das Reporting nur angezogen, wenn die Datei im Wurzel-Verzeichnis liegt. Legt man die Datei nach src/main/resources/ - was eigentlich im Classpath liegt - so gibt es beim
 Erstellen des Reports einen Fehler, dass das Property 'serenity.test.root' - was in der Properties-Datei definiert ist - nicht gesetzt ist!
 
  
 