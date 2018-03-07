package ru.mail.park.rk1.activity;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ru.mail.park.articlelistlib.Article;
import ru.mail.park.articlelistlib.ArticleListFragment;
import ru.mail.park.articlelistlib.OnArticleClickListener;
import ru.mail.park.rk1.R;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArticleListFragment articleListFragment = new ArticleListFragment();
        articleListFragment.setOnArticleClickListener(new ArticleClickListener());

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.list, articleListFragment);
        fragmentTransaction.commit();

    }

    private void addArticle (Article article) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ArticleFragment articleFragment = new ArticleFragment();
        articleFragment.setArticle(article);
        fragmentTransaction.replace(R.id.list, articleFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private class ArticleClickListener implements OnArticleClickListener {

        @Override
        public void onArticleClick(Article article) {
            addArticle(article);
        }
    }




}
