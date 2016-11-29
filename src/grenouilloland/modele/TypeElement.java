package grenouilloland.modele;




/**
 * Type enumere fortement type permettant une strategie sur les nenuphar.
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
public enum TypeElement{

    EAU{
        @Override
        public void effetSurGrenouille(Grenouille grenouille)
        {
			grenouille.setPtVie(0);
			grenouille.mourir();
			System.out.println("Elle est morte !");
		}
    },

	NENUPHARIMMORTEL{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			//rien
		}
	},



    NENUPHAR{
        @Override
        public void effetSurGrenouille(Grenouille grenouille)
        {
            //rien
        }
    },

	NENUPHARVENENEUX{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			if(grenouille.estMalade())
			{
				grenouille.setPtVie(0);
				grenouille.mourir();

			}
			else
			{
				grenouille.rendreMalade();
				grenouille.setPtVie(grenouille.getPtVie()/2);
			}
		}
	},

	NENUPHARNUTRITIF{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			grenouille.setPtVie(grenouille.getPtVie()+1);
			grenouille.guerir();
		}
	},

	NENUPHARDOPANT{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			grenouille.setPtVie(grenouille.getPtVie()*2);
			grenouille.guerir();
		}
	},

	NENUPHARMORTEL{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			grenouille.mourir();
			grenouille.setPtVie(0);
		}
	};

	public abstract void effetSurGrenouille(Grenouille grenouille);

	public static TypeElement auHasard(){
        int nbRand = (int)(Math.random()*(values().length-2))+2;
        return values()[nbRand];
	}



}

