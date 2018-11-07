package softwares.berthesul.speechtotextsample;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.speechController = new STT() {
            @Override
            public void onResults(Bundle bundle) {
                super.onResults(bundle);

                final ArrayList<String> palavras = bundle.getStringArrayList(
                        SpeechRecognizer.RESULTS_RECOGNITION
                );

                String discurso = "";

                if (palavras != null) {
                    discurso += palavras.get(0) + " ";
                }

                Log.i("Você falou MainAct", discurso);

//                tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
//                mainMessage.setText(R.string.mainMessage);
            }
        };

        stt = SpeechRecognizer.createSpeechRecognizer(this);
        stt.setRecognitionListener(speechController);
    }

    public void onVoidMainButtonClick(View v) {
        // Faz algo além

        startListening();
    }

    private void startListening () {
        Intent it = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        it.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "pt-BR");
        it.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getClass().getPackage().getName());
        it.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);

        stt.startListening(it);
    }

    private STT speechController;
    private SpeechRecognizer stt;
}
