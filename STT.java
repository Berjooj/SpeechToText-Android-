package softwares.berthesul.speechtotextsample;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.util.Log;

public class STT implements RecognitionListener {

    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    @Override
    public void onBeginningOfSpeech() {
        setPlaying(true);
    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {
        setPlaying(false);
    }

    @Override
    public void onError(int i) {
        setPlaying(false);
    }

    @Override
    public void onResults(Bundle bundle) {
        Log.i("Err (STT)", "Resultado");
    }

    @Override
    public void onPartialResults(Bundle bundle) {}

    @Override
    public void onEvent(int i, Bundle bundle) {}

    public boolean isPlaying () {
        return this.playing;
    }

    private void setPlaying (boolean status) {
        this.playing = status;
    }

    private boolean playing = false;
}