/*TTSFacade Class
 * Responsible : for turning documents into speech
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTSFacade {
	
	
	public VoiceManager vm;
	public Voice voice;
	
	public TTSFacade() {
		this.vm=VoiceManager.getInstance();
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		this.voice=vm.getVoice("kevin16");
		this.voice.allocate();
	}
	
	public void play(String s ) {
		voice.speak(s);
	}
	//Volume
	public void setVolume(float a) {
		voice.setVolume(a);
	}
	public float getVolume() {
		return voice.getVolume();
	}
	//Pitch
	public void setPitch(int a) {
		voice.setPitch(a);
	}
	public int getPitch() {
		return (int) voice.getPitch();
	}
	//Rate
	public void setRate(int a) {
		voice.setRate(a);
	}
	public int getRate() {
		return (int) voice.getRate();
	}
}
