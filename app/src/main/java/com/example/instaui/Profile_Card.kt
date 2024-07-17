package com.example.instaui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileCardList()
{
    Column {
        Profile_card(
            profileImage = painterResource(id = R.drawable.arjun_post_profile),
            profile_name = "_artjun_",
            profileBelowName = "Kailash Kher, Mounima .Kaun Hain Voh",
            commentedBy = "sai_vathshal_vyas",
            number = "18,507",
            comments = 25,
            postedOn = "March 8",
            img_post = painterResource(id = R.drawable.arjun_post)
        )
        Profile_card(
            profileImage = painterResource(id = R.drawable.profile_pokemon),
            profile_name = "anime_world",
            commentedBy = "revanth",
            number = "16,807",
            comments = 100,
            postedOn = "June 20",
            img_post = painterResource(id = R.drawable.home_page_post2)
        )
        Profile_card(
            profileImage = painterResource(id = R.drawable.profile_satheesh),
            profile_name = "satheesh",
            profileBelowName = "Kailash Kher, Mounima .Kaun Hain Voh",
            commentedBy = "sai_vathshal_vyas",
            number = "1,507",
            comments = 25,
            postedOn = "March 8",
            img_post = painterResource(id = R.drawable.home_page_post1)
        )
        Profile_card(
            profileImage = painterResource(id = R.drawable.arjun_post_profile),
            profile_name = "_artjun_",
            commentedBy = "sai_vathshal_vyas",
            number = "1,507",
            comments = 25,
            postedOn = "March 8",
            img_post = painterResource(id = R.drawable.home_page_post3)
        )
        Profile_card(
            profileImage = painterResource(id = R.drawable.bramhi_profile),
            profile_name = "addicted_to_memes",
            commentedBy = "kokkinti_harshad",
            number = "15,850",
            comments = 54,
            postedOn = "June 8",
            img_post = painterResource(id = R.drawable.search6)
        )
        Profile_card(
            profileImage = painterResource(id = R.drawable.search4),
            profile_name = "arman_ammu",
            commentedBy = "kokkinti_harshad",
            number = "15,850",
            comments = 54,
            postedOn = "June 8",
            img_post = painterResource(id = R.drawable.search4)
        )
    }

}


@Composable
fun Profile_card(profileImage:Painter,profile_name:String,profileBelowName:String?=null,commentedBy:String,number:String,comments:Int,postedOn:String,img_post:Painter)
{
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        Profile_card_top(profileImage = profileImage, profile_name = profile_name, profileBelowName = profileBelowName)
        Image(painter = img_post, contentDescription ="post", modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop)
        ImageBelowIcons()
        TextBelowIcon(commentedBy = commentedBy,number=number,comments=comments, postedOn = postedOn)
    }
}

@Composable
fun Profile_card_top(profileImage:Painter,profile_name:String,profileBelowName:String?=null)
{
    Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = profileImage,
            contentDescription = "",
            modifier = Modifier
                .size(35.dp, 35.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    shape = CircleShape,
                    color = Color.Transparent
                )
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 5.dp)
                .fillMaxWidth(0.9f)

        ){
            Text(text = profile_name, fontSize = 13.sp, modifier = Modifier.padding(bottom = 0.dp))
            if(profileBelowName!=null)
            Text(text = profileBelowName,fontSize = 13.sp)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription ="" )
        }
    }
}

@Composable
fun ImageBelowIcons()
{
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = Modifier
            .fillMaxWidth(0.8f)
            ) {
            var img by remember {
                mutableIntStateOf(R.drawable.heart_outline)
            }
            IconButton(onClick = { if(img==R.drawable.heart_outline) img=R.drawable.heart_filled else img=R.drawable.heart_outline }) {
                Icon(painter = painterResource(id = img), contentDescription ="", modifier = Modifier.size(25.dp) )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.comment), contentDescription ="" , modifier = Modifier.size(25.dp))
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.share), contentDescription ="" , modifier = Modifier.size(25.dp))

            }
        }
        Row() {
            var img by remember {
                mutableIntStateOf(R.drawable.save)
            }
            IconButton(onClick = {  if(img==R.drawable.save) img=R.drawable.save_filled else img=R.drawable.save }) {
                Icon(painter = painterResource(id = img), contentDescription ="", modifier = Modifier.size(27.dp) )
                
            }
        }
    }
}

@Composable
fun TextBelowIcon(commentedBy:String,number:String,comments:Int,postedOn:String)
{
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Row( verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.profile4),
                contentDescription = "",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
            Text(text = "Liked by $commentedBy and $number others", modifier = Modifier.padding(horizontal = 10.dp))
        }
        Text(text = "View all $comments comments", color = Color.Gray)
        Text(text = postedOn, color = Color.Gray)
    }


}