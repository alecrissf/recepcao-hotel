@REM Variáveis
set class_path="bin"

@REM Executar o código
java^
 -cp %class_path%^
 --module-path ./lib/javafx-sdk-11.0.2/lib^
 --add-modules javafx.controls,javafx.fxml^
 com.recepcaohotel.app.App
