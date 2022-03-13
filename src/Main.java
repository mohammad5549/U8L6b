public class Main {
    public static void main(String[] args) {

        Encryptor e1 = new Encryptor(3, 4);
        System.out.println(e1.encryptMessage("What are you doing next weekend?"));

        Encryptor e2 = new Encryptor(6, 5);
        System.out.println(e2.encryptMessage("This one time I was trying to do a handstand and fell backwards and landed on my shoe. It hurt! I won't try that again."));

        Encryptor d1 = new Encryptor(3, 2);
        System.out.println(d1.decryptMessage("Ti hsiscn ofietdnia!Bl e nto helo okotAu!A"));

        Encryptor d2 = new Encryptor(5, 5);
        System.out.println(d2.decryptMessage("Tite hsocmi presa es  stsaneregtd see J  nfaBidomonee  d ftm.cuhe alisBr,ssaieecgllstelft!  -rAwsduA"));

        Encryptor d3 = new Encryptor(6, 5);
        System.out.println(d3.decryptMessage("Meottai ooufdsl rtdcsrnelh e r etWwht hhiihmselgro.nlhen    sld tmc egoehsne  otttcbous oacHusAAkoloAA?ploAA eynAA f !AA"));

        Encryptor d4 = new Encryptor(9, 8);
        System.out.println(d4.decryptMessage("Io ihscnongeoesofn rnn  do.cac poir rprirfnmTyhyso gahpyp ce tit,tteniis  siea o,pc gpttr rotirihmkonhneoeancveasn toee le iiwsro nononstrrtffn atttencxlseoe oitl x rfwp.yptanonh ,l,nar eI a  tmardoiiai stennnlvk ealyit real  zid rcaaaeeeatkinudsc e ndt  icxtt hpcpitoeaoaahp  xcrrnehbptceo tc t  sriird pisinoyoirn gfnpetettio.tssvehnr i eereamEonlnf lannoftert eetoite tl  unondhlctltrceeioode.en gn -r  iiitabcFbenbe eeoustlnw pr annn  patlsc uusne ,rsssedcr ycueuoheaphasdmnantel o is imla-ecoeoey rnc eyoIsotrkr rts  yeaai idtpytntibeht e hslceigdam er oe l.p ymnnbg otpests  r-dtshstb d iaoehuaeeoguset snnets ,wic   ik egrswpneflnyciogyolephesearsi dmi te lr.edcisale ,eooonsqA rmnud uncapar ai obulcsrranlt ekeeut naceehrhrtsr  eooe iymw vrcclpeikiiiaytstedzpn  shyeei dta  ddeeehgtp brribthuAyi puoosA gtit reAtioe uirAhn nnnzsAeartoae.A testudAAooc  t AA"));

        Encryptor myEncryption = new Encryptor(10, 3);
        System.out.println(myEncryption.encryptMessage("This is my encryption message."));

        Encryptor partnerEncryption = new Encryptor(3, 8);
        System.out.println(partnerEncryption.decryptMessage("TauAAAAhicAAAAerkAAAA s!AAAAs AAAAAtsAAAAA"));




    }
}
