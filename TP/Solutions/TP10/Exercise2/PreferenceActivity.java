package com.example.workspace;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.CheckBoxPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.PreferenceFragmentCompat;

public class PreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the fragment containing the preferences
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preference, rootKey);

            CheckBoxPreference activateLanguage = findPreference("pref_activate_language");
            MultiSelectListPreference languagePref = findPreference("pref_language");

            if(activateLanguage!= null & languagePref != null){
                languagePref.setEnabled(activateLanguage.isChecked());

                activateLanguage.setOnPreferenceChangeListener((preference, newValue) -> {
                   boolean isActive = (Boolean) newValue;
                   languagePref.setEnabled(isActive);
                   return true;
                });
            }
        }
    }
}
