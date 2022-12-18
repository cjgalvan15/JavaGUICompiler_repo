package application;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import compilerPrograms.LexicalAnalysis;
import compilerPrograms.ParseTree;
import compilerPrograms.SemanticAnalysis;
import compilerPrograms.SyntaxAnalysis;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable{

	FileChooser fileChooser = new FileChooser();
    @FXML
    private Button clearButton;

    @FXML
    private TextArea inputTextArea;

    @FXML
    private Button lexicalAnalysisButton;

    @FXML
    private Button openFileButton;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Button parseTreeButton;

    @FXML
    private Button semanticAnalysisButton;

    @FXML
    private Button syntaxAnalysisButton;
    
    @FXML
    private MediaView click;
    
    public void lexical(ActionEvent e)
    {
    	//outputTextArea.setText("");
    	String input = inputTextArea.getText();
    	String lexOutput = LexicalAnalysis.tokenize(input);
    	outputTextArea.setText(lexOutput);
    }
    public void syntax(ActionEvent e)
    {
    	//outputTextArea.setText("");
    	String input = inputTextArea.getText();
    	String lexOutput = LexicalAnalysis.tokenize(input);
    	SyntaxAnalysis syntax = new SyntaxAnalysis(lexOutput);
    	outputTextArea.setText(syntax.getSyntax());
    }
    public void semantic(ActionEvent e)
    {
    	String input = inputTextArea.getText();
    	String semanticOutput = SemanticAnalysis.analyzeSemantics(input);
    	outputTextArea.setText(semanticOutput);
    }
    public void parseTree(ActionEvent e)
    {
    	outputTextArea.setText("");
    	String input = inputTextArea.getText();
    	String parseOutput = ParseTree.parser(input);
    	outputTextArea.setText(parseOutput);
    }
    
    public void clear(ActionEvent e)
    {
    	inputTextArea.setText("");
    	outputTextArea.setText("");
    }
    
    public void getFile(ActionEvent event)
    {
    	File file = fileChooser.showOpenDialog(new Stage());
    	try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				inputTextArea.appendText(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		fileChooser.setInitialDirectory(new File("C:\\Users\\Admin\\Desktop"));		
	}
}