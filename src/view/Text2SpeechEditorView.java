/*Text2SpeechEditorView Class
 * Responsible : for creating the GUI and handling the main actions of the application
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import commands.CommandsFactory;
import commands.ReplayManager;
import model.Document;
import model.TTSFacade;

public class Text2SpeechEditorView {
	private static String clipBoard;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplayManager repman = new ReplayManager();
		Document executableDoc = new Document(repman); 
		CommandsFactory cmd = new CommandsFactory(repman);
		JFrame frame = new JFrame("TEXT EDITOR");
		JTextArea textarea = new JTextArea();
		JMenuBar menuBar = new JMenuBar();
		frame.setSize(640 , 640);
		
		
		JMenu open = new JMenu("Open"); 
		JMenuItem browse = new JMenuItem("Browse...");
		browse.addActionListener(cmd.createCommand("OpenDocument", executableDoc , textarea));
		open.add(browse);
		menuBar.add(open);
		
		JMenu save = new JMenu("Save");
		JMenuItem saveDoc = new JMenuItem("Word File");
		saveDoc.addActionListener(cmd.createCommand("SaveDocument", executableDoc, textarea));
		JMenuItem saveExcel = new JMenuItem("Excel File");
		saveExcel.addActionListener(cmd.createCommand("SaveDocument", executableDoc, textarea));
		save.add(saveDoc);
		save.add(saveExcel);
		menuBar.add(save);
		
		JMenu edit = new JMenu("Edit");
		JMenuItem copy = new JMenuItem("Copy");
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clipBoard = new String(textarea.getSelectedText());
			}
		});
		JMenuItem paste = new JMenuItem("Paste");
		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(clipBoard != null) {
			            textarea.replaceRange(clipBoard, textarea.getSelectionStart(),
			                              textarea.getSelectionEnd());
				 }
			}
		});
		JMenuItem cut = new JMenuItem("Cut");
		cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clipBoard = new String(textarea.getSelectedText());
				textarea.replaceRange("", textarea.getSelectionStart(), textarea.getSelectionEnd());
			}
		});
		edit.add(copy);
		edit.add(paste);
		edit.add(cut);
		menuBar.add(edit);
		
		JMenu contentsToAudio = new JMenu("Contents To Audio");
		JMenuItem contents = new JMenuItem("Contents");
		contents.addActionListener(cmd.createCommand("DocumentToSpeech", executableDoc, textarea));
		JMenuItem selectedArea = new JMenuItem("Selected Area");
		selectedArea.addActionListener(cmd.createCommand("LineToSpeech", executableDoc, textarea));
		contentsToAudio.add(contents);
		contentsToAudio.add(selectedArea);
		menuBar.add(contentsToAudio);
		
		JMenu tuneAudio = new JMenu("Tune Audio");
		JMenuItem pitch = new JMenuItem("Pitch");
		pitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTSFacade managerofAudio = executableDoc.getAudioManager();
				String inputValue = JOptionPane.showInputDialog("Type the value of Pitch (Current Pitch is : " + managerofAudio.getPitch() + ") : " );
				int a = Integer.parseInt(inputValue);
				managerofAudio.setPitch(a);
			}
		});
		JMenuItem rate = new JMenuItem("Rate");
		rate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTSFacade managerofAudio = executableDoc.getAudioManager();
				String inputValue = JOptionPane.showInputDialog("Type the value of rate (Current Rate is : " + managerofAudio.getRate() + ") : " );
				int a = Integer.parseInt(inputValue);
				managerofAudio.setRate(a);
			}
		});
		JMenuItem volume = new JMenuItem("Volume");
		volume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTSFacade managerofAudio = executableDoc.getAudioManager();
				String inputValue = JOptionPane.showInputDialog("Type the value of Volume (Current Volume is : " + managerofAudio.getVolume() + ") : " );
				float a = Float.parseFloat(inputValue);
				managerofAudio.setVolume(a);
			}
		});
		tuneAudio.add(pitch);
		tuneAudio.add(rate);
		tuneAudio.add(volume);
		menuBar.add(tuneAudio);
		
		JMenu recording = new JMenu("Recording");
		JMenuItem activate = new JMenuItem("Activate Rec");
		activate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repman.startRecording();
			}
		});
		JMenuItem deactivate = new JMenuItem("Deactivate Rec");
		deactivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repman.endRecording();
			}
		});
		JMenuItem replay = new JMenuItem("Replay");
		replay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repman.replay();
			}
		});
		recording.add(activate);
		recording.add(deactivate);
		recording.add(replay);
		menuBar.add(recording);
		
		frame.setJMenuBar(menuBar);
		frame.add(textarea);
		frame.setVisible(true);
		
	}

}
