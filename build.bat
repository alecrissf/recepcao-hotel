@REM Variáveis
set build_dir="bin"

@REM Compilar os arquivos .java
javac^
 -encoding utf8^
 -d %build_dir%^
 --module-path ./lib/javafx-sdk-11.0.2/lib^
 --add-modules javafx.controls,javafx.fxml^
 ./src/com/recepcaohotel/model/*.java^
 ./src/com/recepcaohotel/model/utils/*.java^
 ./src/com/recepcaohotel/controller/context/*.java^
 ./src/com/recepcaohotel/controller/*.java^
 ./src/com/recepcaohotel/app/*.java

@REM Copiar as pastas de recursos
xcopy "./src/com/recepcaohotel/res" "./%build_dir%/com/recepcaohotel/res" /i /y
xcopy "./src/com/recepcaohotel/view/css" "./%build_dir%/com/recepcaohotel/view/css" /i /y
xcopy "./src/com/recepcaohotel/view/fxml" "./%build_dir%/com/recepcaohotel/view/fxml" /i /y
