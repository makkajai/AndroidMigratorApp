package com.makkajai.androidmigratorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.makkajai.migrator.MigrateToVersionTask;
import com.makkajai.migrator.MigrationManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.w(TAG, "Starting the migration of the app");
        MigrationManager manager = MigrationManager.getMigrationManager();
        manager.addMigration(new MigrateToVersionTask(1) {

            @Override
            public void execute() {
                super.execute();
                Log.w(TAG, "##Starting the migration to version 1");
                //TODO: Do something useful here!
                Log.w(TAG, "##DONE the migration to version 1");
            }
        });
        manager.addMigration(new MigrateToVersionTask(2) {

            @Override
            public void execute() {
                super.execute();
                Log.w(TAG, "##Starting the migration to version 2");
                //TODO: Do something useful here!
                Log.w(TAG, "##DONE the migration to version 2");
            }
        });
        manager.migrate(this);
        Log.w(TAG, "Done with the migration ending the call!");

        setContentView(R.layout.activity_main);
    }
}
