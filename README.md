# Design system lib (lib-theme)

### Introdução:

Lib Android com o objetivo de definir o tema visual de toda a aplicação ou somente activity específica.

### Uso da lib:

O tema pode ser definido atravéz do arquivo AndroidManifest.xml ou programaticamente.

Primeiramente importe o arquivo AAR para dentro do diretório /app/libs/ em seu projeto localizado no nível do módulo. Caso o diretório ainda não exista, crie-o:
<br>No arquivo `build.gradle` do nível do projeto adicione `flatDir{dirs 'libs'}` conforme abaixo:

  ```gradle
  allprojects {
   repositories {
      jcenter()
      flatDir {
        dirs 'libs'
      }
   }
}
  ```

e adicione a dependência `implementation(name: 'lib-theme', ext: 'aar')` no arquivo `build.gradle` do nível da aplicação conforme abaixo:

  ```gradle
  dependencies {
    implementation(name: 'lib-theme-debug', ext: 'aar')
  }
  ``` 

Sincronize o seu projeto e faça conforme a seguir:<br>

- Via AndroidManifest.xml:
    - Em toda a aplicação:
  ```Xml
  <application android:theme="@style/AppTheme">
  ...  
  </application>
  ```
    - Em Activity específica:
  ```Xml
  <activity android:name=".JustActivity" android:theme="@style/AppTheme"/>
  ```  

- Programaticamente:
  A definição deve estar no método `onCreate` antes do `super.onCreate(savedInstanceState)` e `setContentView(R.layout.activity_main)`.
    - Para toda a aplicação, defina em uma classe que extenda a classe Application.
    - Para activity específica, defina na activity que deseja.
  ```Kotlin
  override fun onCreate(savedInstanceState: Bundle?) {

    //  defines theme here
    ThemesHelper(this, ThemesHelper.APPTHEME_BLUE)
  
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
  ```

Utilize os seguites temas:

- Tema padrão: `ThemesHelper.APPTHEME`
- Tema Azul: `ThemesHelper.APPTHEME_BLUE`
- Tema Pink: `ThemesHelper.APPTHEME_PINK`
- Tema Vermelho: `ThemesHelper.APPTHEME_RED`

ex.:

  ```Kotlin
  ThemesHelper(this, ThemesHelper.APPTHEME)
  ```

  ```Kotlin
  ThemesHelper(this, ThemesHelper.APPTHEME_BLUE)
  ```

  ```Kotlin
  ThemesHelper(this, ThemesHelper.APPTHEME_PINK)
  ```

  ```Kotlin
  ThemesHelper(this, ThemesHelper.APPTHEME_RED)
  ```