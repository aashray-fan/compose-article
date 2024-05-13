package com.colab.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.colab.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ArticleContent(
                        coverImage= painterResource(R.drawable.article_cover),
                        title = stringResource(R.string.article_title),
                        subTitle = stringResource(R.string.article_subtitle),
                        description = stringResource(R.string.article_description)
                    )
                }
            }
        }
    }
}


// Cover Image of Article
@Composable
fun ArticleImage(coverImage: Painter, modifier: Modifier=Modifier){
    Image(
        painter = coverImage,
        contentDescription = null
    )
}

// Article Content
@Composable
fun ArticleContent(
    coverImage: Painter,
    title: String,
    subTitle: String,
    description: String,
    modifier: Modifier=Modifier
){
    Column(
        modifier=modifier
    ) {
        ArticleImage(
            coverImage= coverImage
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = subTitle,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = description,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ArticleTheme {
        ArticleContent(
            coverImage= painterResource(R.drawable.article_cover),
            title = stringResource(R.string.article_title),
            subTitle = stringResource(R.string.article_subtitle),
            description = stringResource(R.string.article_description)
        )
    }
}