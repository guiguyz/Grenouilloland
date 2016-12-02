package grenouilloland.modele;




/**
 * Type enumere fortement type permettant une strategie d'effet sur la grenouille
 * via les differents types de nenuphars.
 *
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
			grenouille.setPtVie(-1);
			grenouille.mourir();
		}
    },

	NENUPHARIMMORTEL{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			//le nenuphar immortel n'a aucun effet sur la grenouille
		}
	},



    NENUPHAR{
        @Override
        public void effetSurGrenouille(Grenouille grenouille)
        {
			//le nenuphar normal n'a aucun effet sur la grenouille
        }
    },

	NENUPHARVENENEUX{
        @Override
		public void effetSurGrenouille(Grenouille grenouille)
		{
			if(grenouille.estMalade())
			{
				grenouille.setPtVie(-1);
				grenouille.mourir();

			}
			else
			{
				grenouille.rendreMalade();
				if(grenouille.getPtVie()==0){
					grenouille.setPtVie(-1);
					grenouille.mourir();
				}
				else grenouille.setPtVie(grenouille.getPtVie()/2);
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
			grenouille.setPtVie(-1);
            grenouille.mourir();
		}
	};

    /**
     * Méthode abstraite d'effet sur la grenouille permettant
     * la strategie d'effet redéfinie dans les éléments de l'énum.
     */
	public abstract void effetSurGrenouille(Grenouille grenouille);

    /**
     * Méthode permettant qui génère un nénuphar au hasard.
     * Ne prend pas en compte l'eau et les nénuphar immortel sur la génération.
     */
	public static TypeElement auHasard(){
        int nbRand = (int)(Math.random()*(values().length-2))+2;
        return values()[nbRand];
	}

}

