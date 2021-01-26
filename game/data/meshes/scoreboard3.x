xof 0303txt 0032
template FVFData {
 <b6e70a0e-8ef9-4e83-94ad-ecc8b0c04897>
 DWORD dwFVF;
 DWORD nDWords;
 array DWORD data[nDWords];
}

template EffectInstance {
 <e331f7e4-0559-4cc2-8e99-1cec1657928f>
 STRING EffectFilename;
 [...]
}

template EffectParamFloats {
 <3014b9a0-62f5-478c-9b86-e4ac9f4e418b>
 STRING ParamName;
 DWORD nFloats;
 array FLOAT Floats[nFloats];
}

template EffectParamString {
 <1dbc4c88-94c1-46ee-9076-2c28818c9481>
 STRING ParamName;
 STRING Value;
}

template EffectParamDWord {
 <e13963bc-ae51-4c5d-b00f-cfa3a9d97ce5>
 STRING ParamName;
 DWORD Value;
}


Material PDX01_-_Default {
 1.000000;1.000000;1.000000;1.000000;;
 3.200000;
 0.000000;0.000000;0.000000;;
 0.000000;0.000000;0.000000;;

 TextureFilename {
  "scoreboard3_screen.png";
 }
}

Material Material__4 {
 1.000000;1.000000;1.000000;1.000000;;
 3.200000;
 0.000000;0.000000;0.000000;;
 0.000000;0.000000;0.000000;;

 TextureFilename {
  "scoreboard3_frame.png";
 }
}

Material Material__0 {
 1.000000;1.000000;1.000000;1.000000;;
 3.200000;
 0.000000;0.000000;0.000000;;
 0.000000;0.000000;0.000000;;

 TextureFilename {
  "scoreboard3_l0.png";
 }
}

Material PDX03_-_Default {
 1.000000;1.000000;1.000000;1.000000;;
 3.200000;
 0.000000;0.000000;0.000000;;
 0.000000;0.000000;0.000000;;

 TextureFilename {
  "scoreboard3_r0.png";
 }
}

Mesh Box01 {
 4;
 -157.480316;6.299217;-9.842550;,
 157.480316;6.299217;-9.842496;,
 -157.480316;163.779526;-9.842557;,
 157.480316;163.779526;-9.842503;;
 2;
 3;0,3,1;,
 3;3,0,2;;

 MeshNormals  {
  1;
  0.000000;-0.000000;-1.000000;;
  2;
  3;0,0,0;,
  3;0,0,0;;
 }

 MeshMaterialList  {
  1;
  2;
  0,
  0;
  { PDX01_-_Default }
 }

 MeshTextureCoords  {
  4;
  0.009990;0.990000;,
  19.990007;0.990010;,
  0.009993;-18.990009;,
  19.990009;-18.990002;;
 }
}

Mesh Cylinder02 {
 116;
 156.849899;131.720413;6.147451;,
 147.628998;131.720413;15.368350;,
 138.408096;131.720413;6.147447;,
 147.628998;131.720413;-3.073451;,
 156.849899;218.577682;6.147451;,
 147.628998;218.577682;15.368350;,
 138.408096;218.577682;6.147447;,
 147.628998;218.577682;-3.073451;,
 -163.779541;170.078735;-0.000033;,
 -163.779510;0.000009;-0.000033;,
 -157.480316;170.078735;-0.000032;,
 -157.480286;0.000009;-0.000032;,
 -163.779541;170.078735;-13.825292;,
 -163.779510;0.000009;-13.825292;,
 -157.480316;170.078735;-13.825291;,
 -157.480316;0.000009;-13.825291;,
 -163.779510;-0.000006;-0.000030;,
 163.779526;-0.000006;0.000028;,
 -163.779510;6.299213;-0.000030;,
 163.779526;6.299213;0.000028;,
 -163.779510;-0.000006;-13.825288;,
 163.779526;-0.000006;-13.825231;,
 -163.779510;6.299213;-13.825288;,
 163.779526;6.299213;-13.825231;,
 157.480316;170.078735;0.000023;,
 157.480331;0.000009;0.000023;,
 163.779526;170.078735;0.000024;,
 163.779541;0.000009;0.000024;,
 157.480316;170.078735;-13.825235;,
 157.480331;0.000009;-13.825235;,
 163.779526;170.078735;-13.825234;,
 163.779541;0.000009;-13.825234;,
 -163.779510;163.779526;-0.000037;,
 163.779526;163.779526;0.000020;,
 -163.779510;170.078735;-0.000037;,
 163.779526;170.078735;0.000020;,
 -163.779510;163.779526;-13.825295;,
 163.779526;163.779526;-13.825238;,
 -163.779510;170.078735;-13.825295;,
 163.779526;170.078735;-13.825238;,
 -138.408264;131.720413;6.147399;,
 -147.629150;131.720413;15.368299;,
 -156.850037;131.720413;6.147396;,
 -147.629150;131.720413;-3.073503;,
 -138.408264;218.577667;6.147399;,
 -147.629150;218.577667;15.368299;,
 -156.850037;218.577667;6.147396;,
 -147.629150;218.577667;-3.073503;,
 138.408096;131.720413;6.147447;,
 138.408096;218.577682;6.147447;,
 156.849899;218.577682;6.147451;,
 156.849899;131.720413;6.147451;,
 138.408096;131.720413;6.147447;,
 156.849899;131.720413;6.147451;,
 147.628998;131.720413;15.368350;,
 147.628998;131.720413;-3.073451;,
 147.628998;218.577682;15.368350;,
 147.628998;218.577682;-3.073451;,
 138.408096;218.577682;6.147447;,
 156.849899;218.577682;6.147451;,
 -163.779510;0.000009;-13.825292;,
 -163.779541;170.078735;-13.825292;,
 -163.779510;0.000009;-0.000033;,
 -157.480316;0.000009;-13.825291;,
 -163.779510;0.000009;-13.825292;,
 -157.480286;0.000009;-0.000032;,
 -157.480316;170.078735;-13.825291;,
 -157.480316;0.000009;-13.825291;,
 -157.480316;170.078735;-0.000032;,
 -163.779541;170.078735;-13.825292;,
 -163.779541;170.078735;-0.000033;,
 -157.480316;170.078735;-13.825291;,
 163.779526;-0.000006;-13.825231;,
 -163.779510;-0.000006;-13.825288;,
 163.779526;-0.000006;0.000028;,
 163.779526;6.299213;-13.825231;,
 163.779526;-0.000006;-13.825231;,
 163.779526;6.299213;0.000028;,
 -163.779510;6.299213;-13.825288;,
 163.779526;6.299213;-13.825231;,
 -163.779510;6.299213;-0.000030;,
 -163.779510;-0.000006;-13.825288;,
 -163.779510;-0.000006;-0.000030;,
 -163.779510;6.299213;-13.825288;,
 157.480331;0.000009;-13.825235;,
 157.480316;170.078735;-13.825235;,
 163.779541;0.000009;-13.825234;,
 157.480331;0.000009;0.000023;,
 157.480331;0.000009;-13.825235;,
 163.779526;170.078735;-13.825234;,
 163.779541;0.000009;0.000024;,
 163.779541;0.000009;-13.825234;,
 157.480316;170.078735;-13.825235;,
 163.779526;170.078735;0.000024;,
 163.779526;170.078735;-13.825234;,
 157.480316;170.078735;0.000023;,
 163.779526;163.779526;-13.825238;,
 -163.779510;163.779526;-13.825295;,
 163.779526;163.779526;0.000020;,
 163.779526;170.078735;-13.825238;,
 163.779526;163.779526;-13.825238;,
 163.779526;170.078735;0.000020;,
 -163.779510;170.078735;-13.825295;,
 163.779526;170.078735;-13.825238;,
 -163.779510;170.078735;-0.000037;,
 -163.779510;163.779526;-13.825295;,
 -163.779510;163.779526;-0.000037;,
 -163.779510;170.078735;-13.825295;,
 -156.850037;131.720413;6.147396;,
 -156.850037;218.577667;6.147396;,
 -138.408264;218.577667;6.147399;,
 -138.408264;131.720413;6.147399;,
 -163.779510;170.078735;-0.000037;,
 163.779541;0.000009;0.000024;,
 163.779526;170.078735;0.000020;,
 -163.779510;-0.000006;-0.000030;;
 62;
 3;0,5,1;,
 3;5,0,4;,
 3;1,6,2;,
 3;6,1,5;,
 3;48,7,3;,
 3;7,48,49;,
 3;3,50,51;,
 3;50,3,7;,
 3;52,53,54;,
 3;53,52,55;,
 3;56,57,58;,
 3;57,56,59;,
 3;12,15,13;,
 3;15,12,14;,
 3;8,60,9;,
 3;60,8,61;,
 3;62,63,11;,
 3;63,62,64;,
 3;65,66,10;,
 3;66,65,67;,
 3;68,69,70;,
 3;69,68,71;,
 3;20,23,21;,
 3;23,20,22;,
 3;16,72,17;,
 3;72,16,73;,
 3;74,75,19;,
 3;75,74,76;,
 3;77,78,18;,
 3;78,77,79;,
 3;80,81,82;,
 3;81,80,83;,
 3;31,28,30;,
 3;28,31,29;,
 3;84,24,85;,
 3;24,84,25;,
 3;86,87,88;,
 3;87,86,27;,
 3;89,90,91;,
 3;90,89,26;,
 3;92,93,94;,
 3;93,92,95;,
 3;36,39,37;,
 3;39,36,38;,
 3;32,96,33;,
 3;96,32,97;,
 3;98,99,35;,
 3;99,98,100;,
 3;101,102,34;,
 3;102,101,103;,
 3;104,105,106;,
 3;105,104,107;,
 3;40,45,41;,
 3;45,40,44;,
 3;41,46,42;,
 3;46,41,45;,
 3;108,47,43;,
 3;47,108,109;,
 3;43,110,111;,
 3;110,43,47;,
 3;112,113,114;,
 3;113,112,115;;

 MeshNormals  {
  34;
  1.000000;0.000000;0.000000;,
  -0.000000;0.000000;1.000000;,
  -0.000000;0.000000;1.000000;,
  1.000000;0.000000;0.000000;,
  -1.000000;0.000000;-0.000000;,
  -1.000000;0.000000;-0.000000;,
  0.000000;0.000000;-1.000000;,
  0.000000;0.000000;-1.000000;,
  0.000000;-1.000000;0.000000;,
  0.000000;1.000000;0.000000;,
  0.000000;0.000000;-1.000000;,
  -1.000000;-0.000000;-0.000000;,
  -1.000000;-0.000000;-0.000000;,
  1.000000;0.000000;-0.000002;,
  1.000000;0.000000;0.000000;,
  1.000000;0.000000;0.000000;,
  1.000000;0.000000;-0.000002;,
  1.000000;0.000000;0.000000;,
  -1.000000;0.000000;-0.000000;,
  -1.000000;-0.000000;-0.000000;,
  -1.000000;-0.000000;-0.000000;,
  -1.000000;-0.000000;-0.000000;,
  -1.000000;-0.000000;-0.000000;,
  1.000000;0.000000;0.000000;,
  1.000000;0.000000;0.000000;,
  -0.000000;0.000000;1.000000;,
  -0.000000;0.000000;1.000000;,
  1.000000;0.000000;0.000000;,
  -1.000000;0.000000;-0.000000;,
  -1.000000;0.000000;-0.000000;,
  0.000000;0.000000;-1.000000;,
  0.000000;0.000000;-1.000000;,
  -0.000000;0.000000;1.000000;,
  -0.000000;0.000000;1.000000;;
  62;
  3;0,1,2;,
  3;1,0,3;,
  3;2,4,5;,
  3;4,2,1;,
  3;5,6,7;,
  3;6,5,4;,
  3;7,3,0;,
  3;3,7,6;,
  3;8,8,8;,
  3;8,8,8;,
  3;9,9,9;,
  3;9,9,9;,
  3;10,10,10;,
  3;10,10,10;,
  3;11,12,11;,
  3;12,11,11;,
  3;8,8,8;,
  3;8,8,8;,
  3;13,14,15;,
  3;14,13,16;,
  3;9,9,9;,
  3;9,9,9;,
  3;10,10,10;,
  3;10,10,10;,
  3;8,8,8;,
  3;8,8,8;,
  3;17,17,17;,
  3;17,17,17;,
  3;9,9,9;,
  3;9,9,9;,
  3;18,18,18;,
  3;18,18,18;,
  3;10,10,10;,
  3;10,10,10;,
  3;19,20,21;,
  3;20,19,22;,
  3;8,8,8;,
  3;8,8,8;,
  3;23,23,23;,
  3;23,23,23;,
  3;9,9,9;,
  3;9,9,9;,
  3;10,10,10;,
  3;10,10,10;,
  3;8,8,8;,
  3;8,8,8;,
  3;17,17,17;,
  3;17,17,17;,
  3;9,9,9;,
  3;9,9,9;,
  3;18,18,18;,
  3;18,18,18;,
  3;24,25,26;,
  3;25,24,27;,
  3;26,28,29;,
  3;28,26,25;,
  3;29,30,31;,
  3;30,29,28;,
  3;31,27,24;,
  3;27,31,30;,
  3;32,32,32;,
  3;33,33,33;;
 }

 MeshMaterialList  {
  1;
  62;
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0,
  0;
  { Material__4 }
 }

 MeshTextureCoords  {
  116;
  0.216338;-5.025227;,
  0.497560;-5.025227;,
  0.778782;-5.025227;,
  9.502440;-5.025227;,
  0.216338;-8.995005;,
  0.497560;-8.995005;,
  0.778782;-8.995005;,
  9.502440;-8.995005;,
  5.264003;-6.778378;,
  5.264003;0.995004;,
  4.735996;-6.778378;,
  9.802887;-3.735996;,
  0.004995;-6.778378;,
  0.004996;0.995004;,
  0.197111;-6.778378;,
  0.197111;0.995004;,
  9.995004;-3.735998;,
  0.004995;-3.735971;,
  0.004996;-3.735998;,
  4.735971;0.707101;,
  0.004996;0.995004;,
  9.995004;0.995004;,
  0.004996;0.707101;,
  9.995004;0.707101;,
  5.264030;-6.778378;,
  5.264030;0.995004;,
  4.735970;-6.778378;,
  0.004995;-3.735970;,
  9.802889;-6.778378;,
  9.802889;0.995004;,
  9.995004;-6.778378;,
  9.995005;0.995004;,
  9.995004;-3.735996;,
  0.004995;-3.735969;,
  0.004996;-3.735996;,
  4.735969;-6.778378;,
  0.004996;-6.490477;,
  9.995004;-6.490477;,
  0.004996;-6.778378;,
  9.995004;-6.778378;,
  9.221222;-5.025226;,
  9.502444;-5.025226;,
  9.783667;-5.025226;,
  0.497555;-5.025226;,
  9.221222;-8.995004;,
  9.502444;-8.995004;,
  9.783667;-8.995004;,
  0.497555;-8.995004;,
  9.221218;-5.025227;,
  9.221218;-8.995005;,
  9.783663;-8.995005;,
  9.783663;-5.025227;,
  0.778782;-5.839609;,
  0.216338;-5.839607;,
  0.497560;-8.994980;,
  0.497560;-2.684236;,
  9.502440;-8.994980;,
  9.502440;-2.684236;,
  9.221218;-5.839609;,
  9.783663;-5.839607;,
  9.994976;0.995004;,
  9.994976;-6.778378;,
  9.995004;-3.735997;,
  9.802889;0.994977;,
  9.995004;0.994977;,
  4.735996;0.995004;,
  0.005023;-6.778378;,
  0.005023;0.995004;,
  0.197111;-3.735996;,
  0.004995;0.994977;,
  0.004995;-3.735997;,
  0.197111;0.994977;,
  0.004996;0.995002;,
  9.995004;0.994975;,
  4.735971;0.995004;,
  0.004998;0.707101;,
  0.004998;0.995004;,
  9.995005;-3.735971;,
  0.004996;0.994975;,
  9.995004;0.995002;,
  5.264001;0.707101;,
  9.994975;0.995004;,
  5.264001;0.995004;,
  9.994975;0.707101;,
  9.995003;0.995004;,
  9.995003;-6.778378;,
  0.004995;0.995003;,
  0.197111;-3.735971;,
  0.197111;0.995002;,
  0.004997;-6.778378;,
  4.735970;0.995004;,
  0.004997;0.995004;,
  9.802889;0.995002;,
  9.995005;-3.735970;,
  9.995004;0.995003;,
  9.802889;-3.735971;,
  0.004996;0.995005;,
  9.995004;0.994978;,
  4.735969;-6.490477;,
  0.004995;-6.778378;,
  0.004995;-6.490477;,
  9.995005;-3.735969;,
  0.004996;0.994978;,
  9.995004;0.995005;,
  5.264005;-6.778378;,
  9.994978;-6.490477;,
  5.264005;-6.490477;,
  9.994978;-6.778378;,
  0.216334;-5.025226;,
  0.216334;-8.995004;,
  0.778777;-8.995004;,
  0.778777;-5.025226;,
  9.995004;-6.778378;,
  0.004995;0.995004;,
  0.004995;-6.778378;,
  9.995004;0.995004;;
 }
}

Mesh Plane01 {
 4;
 -121.226944;33.122375;-19.999998;,
 -21.226944;33.122375;-19.999998;,
 -121.226944;133.122375;-20.000002;,
 -21.226944;133.122375;-20.000002;;
 2;
 3;2,3,0;,
 3;1,0,3;;

 MeshNormals  {
  1;
  0.000000;-0.000000;-1.000000;;
  2;
  3;0,0,0;,
  3;0,0,0;;
 }

 MeshMaterialList  {
  1;
  2;
  0,
  0;
  { Material__0 }
 }

 MeshTextureCoords  {
  4;
  0.000000;1.000000;,
  1.000000;1.000000;,
  0.000000;0.000000;,
  1.000000;0.000000;;
 }
}

Mesh Plane02 {
 4;
 23.570618;33.122375;-19.999998;,
 123.570618;33.122375;-19.999998;,
 23.570618;133.122375;-20.000002;,
 123.570618;133.122375;-20.000002;;
 2;
 3;2,3,0;,
 3;1,0,3;;

 MeshNormals  {
  1;
  0.000000;-0.000000;-1.000000;;
  2;
  3;0,0,0;,
  3;0,0,0;;
 }

 MeshMaterialList  {
  1;
  2;
  0,
  0;
  { PDX03_-_Default }
 }

 MeshTextureCoords  {
  4;
  0.000000;1.000000;,
  1.000000;1.000000;,
  0.000000;0.000000;,
  1.000000;0.000000;;
 }
}