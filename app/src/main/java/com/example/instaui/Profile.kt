package com.example.instaui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Profile()
{
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            TopSection()
            Spacer(modifier = Modifier.height(6.dp))
        }
        item {
            TopSectionText(name = "Jilakara Revanth Kumar", description = "I am not responsible for different versions of me in people mind")
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
            TopSectionButtons()
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
            StoryRow()
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
            PostTabView(imageWithTexts =listOf(
                StoryRowItemData(img = painterResource(id = R.drawable.squared_icon), text = "Revath"),
                StoryRowItemData(img = painterResource(id = R.drawable.reels_filled), text = "Revath"),
                StoryRowItemData(img = painterResource(id = R.drawable.profile_filled), text = "Revath"),

                )) {
                selectedIndex=it
            }
            when(selectedIndex)
            {
                0-> PostSection1(posts = listOf(
                    painterResource(id = R.drawable.p1),
                    painterResource(id = R.drawable.p2),
                    painterResource(id = R.drawable.p3),
                    painterResource(id = R.drawable.p4),
                    painterResource(id = R.drawable.p5),
                    painterResource(id = R.drawable.p6),
                    painterResource(id = R.drawable.p7),
                    painterResource(id = R.drawable.p10),
                    painterResource(id = R.drawable.p9),
                    painterResource(id = R.drawable.p11),
                    painterResource(id = R.drawable.p12),
                    painterResource(id = R.drawable.p13),
                    painterResource(id = R.drawable.p14),
                    painterResource(id = R.drawable.p15),
                    painterResource(id = R.drawable.p16),
                    painterResource(id = R.drawable.p17),
                    painterResource(id = R.drawable.p18),
                    painterResource(id = R.drawable.p19),

                ))
                1-> PostSection2()
                else->  PostSection1(posts = listOf(
                    painterResource(id = R.drawable.pp1),
                    painterResource(id = R.drawable.pp2),
                    painterResource(id = R.drawable.pp3),
                    painterResource(id = R.drawable.pp4),


                    ))
            }
        }





    }
}

@Composable
fun TopSection()
{
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(start = 25.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically){
        RoundImage(image = painterResource(id = R.drawable.profile))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            TopSectionItem(a = "19", b = "posts")
            TopSectionItem(a = "241", b = "followers")
            TopSectionItem(a = "627", b = "following")
        }

    }
}


@Composable
fun RoundImage(image: Painter, modifier: Modifier=Modifier)
{
    Image(painter = image, contentDescription ="Rounded Image", modifier
        .border(width = 1.dp, color = Color.White, shape = CircleShape)
        .size(80.dp, 80.dp)
        .clip(
            CircleShape
        ) )

}

@Composable
fun TopSectionItem(a:String,b:String)
{
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = a, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(3.dp))
        Text(text =b, fontSize = 12.sp ,fontWeight = FontWeight.SemiBold)

    }
}

@Composable
fun TopSectionText(name:String,description:String)
{
    Column(modifier = Modifier.padding(start = 12.dp, top = 7.dp, end = 12.dp)) {
        Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = description)
    }
}


@Composable
fun TopSectionButtons()
{
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){

            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.LightGray), modifier = Modifier.fillMaxWidth(0.35f)) {
                Text(text = "Edit Profile", color = Color.Black

                )
            }
        Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(Color.LightGray), modifier = Modifier.fillMaxWidth(0.63f)) {
            Text(text = "Share Profile", color = Color.Black
            )
        }
        Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(Color.LightGray),) {
            Image(painter = painterResource(id = R.drawable.profile_filled), contentDescription ="", modifier = Modifier.size(22.dp) )
        }
    }
}


@Composable
fun StoryRow()
{
    val list= mutableListOf<StoryRowItemData>()
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.a),text = "Birthdays"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.b),text = "Trips"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.c),text = "college fun"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.d),text = "satheesh"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.e),text = "my Birthday"))
    list.add(StoryRowItemData(img= painterResource(id = R.drawable.f),text = "Kadapa trip"))


    LazyRow {
        itemsIndexed(list)
        {
                index, item ->
            StoryRowItem(img = item.img, text = item.text,Color.Gray,80.dp)
        }
    }
}

@Composable
fun StoryRowRoundImg(img: Painter,borderColor: Color,size:Dp)
{
    Box(modifier = Modifier.padding(vertical = 2.dp))
    {
        Image(
            painter = img,
            contentDescription = "Rounded Image",
            modifier = Modifier
                .border(width = 3.dp, color = borderColor, shape = CircleShape)
                .padding(3.dp)
                .size(size, size)
                .clip(
                    CircleShape
                )
                .border(width = 5.dp, color = Color.White, shape = CircleShape)
                .padding(5.dp)
                .border(width = 1.dp, color = Color.White, shape = CircleShape)
        )
    }
}

@Composable
fun StoryRowItem(img: Painter, text:String,borderColor: Color,size:Dp)
{
    Column(modifier = Modifier.padding(2.dp).size(width =90.dp, height = 120.dp ), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        StoryRowRoundImg(img = img,borderColor,size)
        Text(text = text,overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(top = 1.dp), fontSize = 16.sp)
    }
}

data class StoryRowItemData(
    val img: Painter,
    val text:String
)

@Composable
fun PostTabView(
    imageWithTexts:List<StoryRowItemData>,
    onTabSelected: (selectedIndex:Int)->Unit
){
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val inactiveColor= Color.LightGray
    TabRow(selectedTabIndex = selectedTabIndex,
        contentColor = Color.Black
    ) {

        imageWithTexts.forEachIndexed()
        {
                index, item ->
            Tab(selected = selectedTabIndex==index, unselectedContentColor = inactiveColor, selectedContentColor = Color.Black, onClick = {
                selectedTabIndex=index
                onTabSelected(index)
            }) {
                androidx.compose.material3.Icon(
                    painter = item.img,
                    contentDescription ="Posts",
                    tint = if (selectedTabIndex==index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }
}

@Composable
fun PostSection1(posts:List<Painter>)
{
    LazyVerticalGrid(columns = GridCells.Fixed(3),
        modifier = Modifier.scale(1.01f).height(650.dp)) {
        items(posts.size)
        {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(1.dp, color = Color.Black)
            )
        }

    }
}

@Composable
fun PostSection2()
{
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .padding(top = 25.dp)
        .fillMaxWidth()) {
        Text(text = "Share a moment with the world", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Create your first reel", color = Color.Blue, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    }
}
